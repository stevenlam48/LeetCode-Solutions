package convertnumberwordstodigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertNumberWordsToDigitsTest {
    private val solution = Solution()

    @Test
    fun testAllDigits() {
        assertEquals("01234", solution.convertNumber("zeroonetwothreefour"))
    }

    @Test
    fun testMixedOrder() {
        assertEquals("1403", solution.convertNumber("onefourzerothree"))
    }

    @Test
    fun testLongerWords() {
        assertEquals("2986", solution.convertNumber("twonineeightsix"))
    }
}
