package equalsumarrayswithminimumnumberofoperations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualSumArraysWithMinimumNumberOfOperationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.minOperations(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(1, 1, 2, 2, 2, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, solution.minOperations(intArrayOf(1, 1, 1, 1, 1, 1, 1), intArrayOf(6)))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.minOperations(intArrayOf(6, 6), intArrayOf(1)))
    }

    @Test
    fun testAlreadyEqual() {
        assertEquals(0, solution.minOperations(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
        assertEquals(0, solution.minOperations(intArrayOf(6), intArrayOf(6)))
    }

    @Test
    fun testOneOperationNeeded() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 2, 3, 4), intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun testImpossibleByCount() {
        assertEquals(-1, solution.minOperations(intArrayOf(6), intArrayOf(1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun testSingleOperation() {
        assertEquals(1, solution.minOperations(intArrayOf(1), intArrayOf(6)))
        assertEquals(1, solution.minOperations(intArrayOf(6), intArrayOf(1)))
    }
}
