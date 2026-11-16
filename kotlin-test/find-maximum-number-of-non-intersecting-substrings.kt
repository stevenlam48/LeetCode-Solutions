package findmaximumnumberofnonintersectingsubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumNumberOfNonIntersectingSubstringsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxSubstrings("abcdeafdef"))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maxSubstrings("bcdaaaab"))
    }

    @Test
    fun example3() {
        assertEquals(1, Solution().maxSubstrings("aaaa"))
    }

    @Test
    fun tooShort() {
        assertEquals(0, Solution().maxSubstrings("abc"))
    }

    @Test
    fun exactlyFour() {
        assertEquals(0, Solution().maxSubstrings("abcd"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, Solution().maxSubstrings(""))
    }
}
