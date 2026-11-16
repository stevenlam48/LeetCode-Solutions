package maximizecountofdistinctprimesaftersplit

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximizeCountOfDistinctPrimesAfterSplitTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(3),
            solution.maximumCount(intArrayOf(2, 3, 5), arrayOf(intArrayOf(0, 2)))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(3),
            solution.maximumCount(intArrayOf(2, 3, 5), arrayOf(intArrayOf(0, 3)))
        )
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(2),
            solution.maximumCount(intArrayOf(2, 3, 5), arrayOf(intArrayOf(0, 4)))
        )
    }

    @Test
    fun testDuplicatePrime() {
        assertArrayEquals(
            intArrayOf(3),
            solution.maximumCount(intArrayOf(2, 2, 3), arrayOf(intArrayOf(0, 2)))
        )
        assertArrayEquals(
            intArrayOf(3),
            solution.maximumCount(intArrayOf(2, 2, 3), arrayOf(intArrayOf(1, 3)))
        )
    }

    @Test
    fun testNoPrimes() {
        assertArrayEquals(
            intArrayOf(0),
            solution.maximumCount(intArrayOf(4, 6, 8), arrayOf(intArrayOf(0, 4)))
        )
        assertArrayEquals(
            intArrayOf(1),
            solution.maximumCount(intArrayOf(4, 6, 8), arrayOf(intArrayOf(0, 2)))
        )
    }
}
