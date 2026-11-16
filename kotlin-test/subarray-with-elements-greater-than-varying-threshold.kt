package subarraywithelementsgreaterthanvaryingthreshold

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubarrayWithElementsGreaterThanVaryingThresholdTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().validSubarraySize(intArrayOf(1, 3, 4, 3, 1), 6))
    }

    @Test
    fun testExample2() {
        assertEquals(3, Solution().validSubarraySize(intArrayOf(6, 5, 6, 5, 8), 7))
    }

    @Test
    fun testNoValidSubarray() {
        assertEquals(-1, Solution().validSubarraySize(intArrayOf(1, 1, 1), 5))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().validSubarraySize(intArrayOf(10), 9))
        assertEquals(-1, Solution().validSubarraySize(intArrayOf(10), 10))
    }

    @Test
    fun testWholeArray() {
        assertEquals(4, Solution().validSubarraySize(intArrayOf(5, 5, 5, 5), 19))
    }
}
