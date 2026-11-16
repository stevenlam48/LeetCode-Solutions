package shortestsubarraywithoratleastki

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestSubarrayWithOrAtLeastKITest {
    @Test
    fun findsSingleElementSubarray() {
        assertEquals(1, Solution().minimumSubarrayLength(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun needsWholeArray() {
        assertEquals(3, Solution().minimumSubarrayLength(intArrayOf(2, 1, 8), 10))
    }

    @Test
    fun returnsMinusOneWhenOrIsTooSmall() {
        assertEquals(-1, Solution().minimumSubarrayLength(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun handlesKZero() {
        assertEquals(1, Solution().minimumSubarrayLength(intArrayOf(1, 2), 0))
    }

    @Test
    fun skipsValuesWhoseBitsAreCovered() {
        assertEquals(3, Solution().minimumSubarrayLength(intArrayOf(5, 1, 4, 2), 7))
        assertEquals(2, Solution().minimumSubarrayLength(intArrayOf(1, 2, 4), 6))
    }
}
