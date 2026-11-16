package findlongestawesomesubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLongestAwesomeSubstringTest {
    @Test
    fun findsLongestSubstringWithOneOddDigitCount() {
        assertEquals(5, Solution().longestAwesome("3242415"))
    }

    @Test
    fun fallsBackToSingleDigitWhenNoLongerAwesomeSubstringExists() {
        assertEquals(1, Solution().longestAwesome("12345678"))
    }

    @Test
    fun acceptsEntireString() {
        assertEquals(6, Solution().longestAwesome("213123"))
        assertEquals(3, Solution().longestAwesome("111"))
    }

    @Test
    fun handlesEmptyString() {
        assertEquals(0, Solution().longestAwesome(""))
    }
}
