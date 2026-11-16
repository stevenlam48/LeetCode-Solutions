package minimumxorsumoftwoarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumXorSumOfTwoArraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minimumXORSum(intArrayOf(1, 2), intArrayOf(2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(8, solution.minimumXORSum(intArrayOf(1, 0, 3), intArrayOf(5, 3, 4)))
    }

    @Test
    fun testIdenticalArrays() {
        assertEquals(0, solution.minimumXORSum(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7, solution.minimumXORSum(intArrayOf(3), intArrayOf(4)))
    }

    @Test
    fun testZeros() {
        assertEquals(0, solution.minimumXORSum(intArrayOf(0, 0), intArrayOf(0, 0)))
    }
}
