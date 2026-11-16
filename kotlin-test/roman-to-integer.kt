package romantointeger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RomanToIntegerTest {
    @Test
    fun additiveNumerals() {
        assertEquals(3, Solution().romanToInt("III"))
    }

    @Test
    fun leetCodeExampleFiftyEight() {
        assertEquals(58, Solution().romanToInt("LVIII"))
    }

    @Test
    fun leetCodeExampleMcmxciv() {
        assertEquals(1994, Solution().romanToInt("MCMXCIV"))
    }

    @Test
    fun singleSymbol() {
        assertEquals(1000, Solution().romanToInt("M"))
    }

    @Test
    fun subtractivePairs() {
        assertEquals(4, Solution().romanToInt("IV"))
        assertEquals(9, Solution().romanToInt("IX"))
        assertEquals(40, Solution().romanToInt("XL"))
    }

    @Test
    fun longestNumeral() {
        assertEquals(3999, Solution().romanToInt("MMMCMXCIX"))
    }
}
