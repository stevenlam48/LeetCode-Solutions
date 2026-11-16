package distinctnumbersineachsubarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistinctNumbersInEachSubarrayTest {
    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(3, 2, 3), Solution().distinctNumbers(intArrayOf(1, 2, 3, 2, 1), 3))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(2, 2, 2, 2), Solution().distinctNumbers(intArrayOf(1, 2, 1, 2, 1), 2))
    }

    @Test
    fun testKEqualsOne() {
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1), Solution().distinctNumbers(intArrayOf(1, 1, 1, 1, 1), 1))
    }

    @Test
    fun testKEqualsLength() {
        assertArrayEquals(intArrayOf(3), Solution().distinctNumbers(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testAllDistinct() {
        assertArrayEquals(intArrayOf(2, 2, 2), Solution().distinctNumbers(intArrayOf(1, 2, 3, 4), 2))
    }
}
