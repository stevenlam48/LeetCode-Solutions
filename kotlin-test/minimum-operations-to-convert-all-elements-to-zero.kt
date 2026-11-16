package minimumoperationstoconvertallelementstozero

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToConvertAllElementsToZeroTest {

    @Test
    fun testExample1() {
        assertEquals(1, Solution().minOperations(intArrayOf(0, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(4, Solution().minOperations(intArrayOf(3, 1, 4, 1, 5)))
    }

    @Test
    fun testAllZero() {
        assertEquals(0, Solution().minOperations(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().minOperations(intArrayOf(4)))
        assertEquals(0, Solution().minOperations(intArrayOf(0)))
    }

    @Test
    fun testIncreasingDistinct() {
        assertEquals(3, Solution().minOperations(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testDecreasing() {
        assertEquals(5, Solution().minOperations(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun testValley() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 2, 1)))
    }
}
