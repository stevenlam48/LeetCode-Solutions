package subarrayproductlessthank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarrayProductLessThanKTest {
    @Test
    fun testExample1() {
        assertEquals(8, Solution().numSubarrayProductLessThanK(intArrayOf(10, 5, 2, 6), 100))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().numSubarrayProductLessThanK(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(0, Solution().numSubarrayProductLessThanK(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().numSubarrayProductLessThanK(intArrayOf(5), 6))
        assertEquals(0, Solution().numSubarrayProductLessThanK(intArrayOf(5), 5))
    }

    @Test
    fun testAllOnes() {
        assertEquals(6, Solution().numSubarrayProductLessThanK(intArrayOf(1, 1, 1), 2))
    }
}
