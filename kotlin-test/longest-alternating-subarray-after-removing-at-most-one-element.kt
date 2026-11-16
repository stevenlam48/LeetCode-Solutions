package longestalternatingsubarrayafterremovingatmostoneelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestAlternatingSubarrayAfterRemovingAtMostOneElementTest {
    @Test
    fun singleElement() {
        assertEquals(1, Solution().longestAlternating(intArrayOf(5)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().longestAlternating(intArrayOf(1, 2)))
        assertEquals(2, Solution().longestAlternating(intArrayOf(2, 1)))
    }

    @Test
    fun removalNeededInTheMiddle() {
        assertEquals(3, Solution().longestAlternating(intArrayOf(1, 2, 3, 2)))
    }

    @Test
    fun alreadyAlternating() {
        assertEquals(4, Solution().longestAlternating(intArrayOf(1, 3, 2, 4)))
        assertEquals(5, Solution().longestAlternating(intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    fun strictlyMonotonic() {
        assertEquals(2, Solution().longestAlternating(intArrayOf(1, 2, 3)))
        assertEquals(2, Solution().longestAlternating(intArrayOf(3, 2, 1)))
    }

    @Test
    fun allEqual() {
        assertEquals(1, Solution().longestAlternating(intArrayOf(1, 1, 1, 1)))
    }
}
