package differencebetweenmaximumandminimumpricesum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferenceBetweenMaximumAndMinimumPriceSumTest {
    @Test
    fun testExample1() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(23L, Solution().maxOutput(3, edges, intArrayOf(1, 3, 20)))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        assertEquals(7L, Solution().maxOutput(4, edges, intArrayOf(1, 3, 2, 4)))
    }

    @Test
    fun testSingleNode() {
        assertEquals(0L, Solution().maxOutput(1, emptyArray(), intArrayOf(5)))
    }

    @Test
    fun testTwoNodes() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertEquals(7L, Solution().maxOutput(2, edges, intArrayOf(3, 7)))
    }

    @Test
    fun testStar() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(5L, Solution().maxOutput(4, edges, intArrayOf(1, 2, 3, 4)))
    }
}
