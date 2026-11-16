package describethepainting

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DescribeThePaintingTest {
    private val solution = Solution()

    private fun check(expected: Array<LongArray>, actual: Array<LongArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun testExample1() {
        val segments = arrayOf(intArrayOf(1, 4, 5), intArrayOf(4, 7, 7), intArrayOf(1, 7, 9))
        check(arrayOf(longArrayOf(1, 4, 14), longArrayOf(4, 7, 16)), solution.splitPainting(segments))
    }

    @Test
    fun testExample2() {
        val segments = arrayOf(
            intArrayOf(1, 7, 9), intArrayOf(6, 8, 15), intArrayOf(8, 10, 7)
        )
        check(
            arrayOf(
                longArrayOf(1, 6, 9), longArrayOf(6, 7, 24),
                longArrayOf(7, 8, 15), longArrayOf(8, 10, 7)
            ),
            solution.splitPainting(segments)
        )
    }

    @Test
    fun testExample3() {
        val segments = arrayOf(
            intArrayOf(1, 4, 5), intArrayOf(1, 4, 7),
            intArrayOf(4, 7, 1), intArrayOf(4, 7, 11)
        )
        check(arrayOf(longArrayOf(1, 4, 12), longArrayOf(4, 7, 12)), solution.splitPainting(segments))
    }

    @Test
    fun testSingleSegment() {
        val segments = arrayOf(intArrayOf(1, 5, 3))
        check(arrayOf(longArrayOf(1, 5, 3)), solution.splitPainting(segments))
    }

    @Test
    fun testAdjacentNoOverlap() {
        val segments = arrayOf(intArrayOf(1, 2, 4), intArrayOf(2, 3, 6))
        check(arrayOf(longArrayOf(1, 2, 4), longArrayOf(2, 3, 6)), solution.splitPainting(segments))
    }
}
