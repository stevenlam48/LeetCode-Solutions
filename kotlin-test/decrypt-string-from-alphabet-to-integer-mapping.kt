package decryptstringfromalphabettointegermapping

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecryptStringFromAlphabetToIntegerMappingTest {
    private val solution = Solution()

    @Test
    fun twoDigitMappings() {
        assertEquals("jkab", solution.freqAlphabets("10#11#12"))
    }

    @Test
    fun mixedSingleAndDoubleDigits() {
        assertEquals("acz", solution.freqAlphabets("1326#"))
    }

    @Test
    fun allLetters() {
        assertEquals("abcdefghijklmnopqrstuvwxyz", solution.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"))
    }

    @Test
    fun emptyString() {
        assertEquals("", solution.freqAlphabets(""))
    }
}
