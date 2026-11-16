package longestnondecreasingsubarrayafterreplacingatmostoneelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestNonDecreasingSubarrayAfterReplacingAtMostOneElementTest {
    @Test
    fun alreadyNonDecreasing() {
        assertEquals(5, Solution().longestSubarray(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun strictlyDecreasing() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun mountainShape() {
        assertEquals(4, Solution().longestSubarray(intArrayOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(3, Solution().longestSubarray(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().longestSubarray(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().longestSubarray(intArrayOf(2, 1)))
    }
}
