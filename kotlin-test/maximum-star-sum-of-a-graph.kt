package maximumstarsumofagraph

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStarSumOfAGraphTest {
    @Test
    fun example1() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(17, Solution().maxStarSum(intArrayOf(1, 2, 3, 4, 10), edges, 2))
    }

    @Test
    fun kZero() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(10, Solution().maxStarSum(intArrayOf(1, 2, 3, 4, 10), edges, 0))
    }

    @Test
    fun negativeValues() {
        assertEquals(-1, Solution().maxStarSum(intArrayOf(-1, -2), arrayOf(intArrayOf(0, 1)), 1))
    }

    @Test
    fun singleNode() {
        assertEquals(5, Solution().maxStarSum(intArrayOf(5), arrayOf(), 3))
    }

    @Test
    fun kLargerThanDegree() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2)
        )
        assertEquals(10, Solution().maxStarSum(intArrayOf(1, 4, 5), edges, 5))
    }
}
