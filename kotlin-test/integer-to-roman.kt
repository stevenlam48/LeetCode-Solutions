package integertoroman

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerToRomanTest {
    @Test
    fun convertsRepeatedUnits() {
        assertEquals("III", Solution().intToRoman(3))
    }

    @Test
    fun convertsLeetCodeExamples() {
        assertEquals("LVIII", Solution().intToRoman(58))
        assertEquals("MCMXCIV", Solution().intToRoman(1994))
    }

    @Test
    fun convertsEverySubtractiveForm() {
        assertEquals("IV", Solution().intToRoman(4))
        assertEquals("IX", Solution().intToRoman(9))
        assertEquals("XL", Solution().intToRoman(40))
        assertEquals("XC", Solution().intToRoman(90))
        assertEquals("CD", Solution().intToRoman(400))
        assertEquals("CM", Solution().intToRoman(900))
    }

    @Test
    fun convertsMaximumRomanInput() {
        assertEquals("MMMCMXCIX", Solution().intToRoman(3999))
    }
}
