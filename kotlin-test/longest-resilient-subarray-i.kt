package longestresilientsubarrayi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestResilientSubarrayITest {
    @Test
    fun kEqualsOne() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun mixedRemainders() {
        assertEquals(1, Solution().resilientSubarray(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun allEven() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(2, 4, 6), 2))
    }

    @Test
    fun allOdd() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(1, 3, 5), 2))
    }

    @Test
    fun oddLengthFails() {
        assertEquals(3, Solution().resilientSubarray(intArrayOf(1, 3, 5, 7), 2))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().resilientSubarray(intArrayOf(5), 3))
    }
}
