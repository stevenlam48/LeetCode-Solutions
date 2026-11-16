package rearrangingfruits

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangingFruitsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1L, solution.minCost(intArrayOf(4, 2, 2, 2), intArrayOf(1, 4, 1, 2)))
    }

    @Test
    fun testIdenticalBaskets() {
        assertEquals(0L, solution.minCost(intArrayOf(2, 3, 4, 1), intArrayOf(3, 2, 4, 1)))
        assertEquals(0L, solution.minCost(intArrayOf(1, 1), intArrayOf(1, 1)))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1L, solution.minCost(intArrayOf(1, 2), intArrayOf(1, 3)))
        assertEquals(-1L, solution.minCost(intArrayOf(1, 1, 1), intArrayOf(1, 1, 2)))
    }

    @Test
    fun testDirectSwaps() {
        assertEquals(3L, solution.minCost(intArrayOf(1, 1, 2, 2), intArrayOf(3, 3, 4, 4)))
    }

    @Test
    fun testUseMinimumAsIntermediary() {
        assertEquals(3L, solution.minCost(intArrayOf(1, 1, 100, 100), intArrayOf(101, 101, 102, 102)))
    }

    @Test
    fun testSinglePair() {
        assertEquals(1L, solution.minCost(intArrayOf(1, 1), intArrayOf(2, 2)))
    }
}
