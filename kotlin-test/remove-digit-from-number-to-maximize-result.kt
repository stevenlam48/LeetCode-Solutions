package removedigitfromnumbertomaximizeresult

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDigitFromNumberToMaximizeResultTest {
    @Test
    fun lastDigit() {
        assertEquals("12", Solution().removeDigit("123", '3'))
    }

    @Test
    fun removeEarlierOccurrence() {
        assertEquals("231", Solution().removeDigit("1231", '1'))
    }

    @Test
    fun removeLastOccurrenceWhenEarlierDoesNotHelp() {
        assertEquals("51", Solution().removeDigit("551", '5'))
    }

    @Test
    fun allOccurrencesAreEqual() {
        assertEquals("11", Solution().removeDigit("111", '1'))
    }
}
