package findlongestspecialsubstringthatoccursthricei

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindLongestSpecialSubstringThatOccursThriceITest {
    @Test
    fun findsLengthWithinOneLongRun() {
        assertEquals(2, Solution().maximumLength("aaaa"))
    }

    @Test
    fun combinesOccurrencesAcrossMultipleRuns() {
        assertEquals(2, Solution().maximumLength("aaabbbaa"))
        assertEquals(1, Solution().maximumLength("abcaba"))
    }

    @Test
    fun returnsMinusOneWhenNoSubstringOccursThreeTimes() {
        assertEquals(-1, Solution().maximumLength("abcdef"))
        assertEquals(-1, Solution().maximumLength(""))
    }
}
