package maximumsizesubarraysumequalsk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSizeSubarraySumEqualsKTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().maxSubArrayLen(intArrayOf(1, -1, 5, -2, 3), 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxSubArrayLen(intArrayOf(-2, -1, 2, 1), 1))
    }

    @Test
    fun wholeArray() {
        assertEquals(3, Solution().maxSubArrayLen(intArrayOf(1, 2, 3), 6))
    }

    @Test
    fun noMatch() {
        assertEquals(0, Solution().maxSubArrayLen(intArrayOf(1), 0))
    }

    @Test
    fun zeros() {
        assertEquals(3, Solution().maxSubArrayLen(intArrayOf(0, 0, 0), 0))
    }
}
