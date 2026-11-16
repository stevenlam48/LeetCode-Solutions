package longestalternatingsubarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestAlternatingSubarrayTest {
    @Test
    fun incrementingStart() {
        assertEquals(4, Solution().alternatingSubarray(intArrayOf(2, 3, 4, 3, 4)))
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(2, Solution().alternatingSubarray(intArrayOf(4, 5, 6)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().alternatingSubarray(intArrayOf(2, 3)))
        assertEquals(-1, Solution().alternatingSubarray(intArrayOf(3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(-1, Solution().alternatingSubarray(intArrayOf(1)))
    }

    @Test
    fun allEqual() {
        assertEquals(-1, Solution().alternatingSubarray(intArrayOf(1, 1, 1)))
    }
}
