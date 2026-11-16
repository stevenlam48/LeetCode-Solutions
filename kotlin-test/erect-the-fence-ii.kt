package erectthefenceii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ErectTheFenceIITest {
    private val solution = Solution()

    private fun assertCircle(expected: DoubleArray, actual: DoubleArray) {
        assertEquals(3, actual.size)
        for (i in 0 until 3) {
            assertEquals(expected[i], actual[i], 1e-5, "coordinate $i")
        }
    }

    @Test
    fun testExample1() {
        val result = solution.outerTrees(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(2, 0),
                intArrayOf(2, 4), intArrayOf(3, 3), intArrayOf(4, 2)
            )
        )
        assertCircle(doubleArrayOf(2.0, 2.0, 2.0), result)
    }

    @Test
    fun testExample2() {
        val result = solution.outerTrees(
            arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(2, 0))
        )
        assertCircle(doubleArrayOf(2.0, 1.0, 1.0), result)
    }

    @Test
    fun testSinglePoint() {
        assertCircle(doubleArrayOf(0.0, 0.0, 0.0), solution.outerTrees(arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun testTwoPoints() {
        assertCircle(
            doubleArrayOf(1.0, 0.0, 1.0),
            solution.outerTrees(arrayOf(intArrayOf(0, 0), intArrayOf(2, 0)))
        )
    }

    @Test
    fun testCollinearPoints() {
        assertCircle(
            doubleArrayOf(1.0, 1.0, 1.41421356),
            solution.outerTrees(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2)))
        )
    }
}
