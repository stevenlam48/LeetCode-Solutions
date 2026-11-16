package integertoenglishwords

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerToEnglishWordsTest {
    @Test
    fun handlesZeroAndSingleDigits() {
        assertEquals("Zero", Solution().numberToWords(0))
        assertEquals("Nine", Solution().numberToWords(9))
    }

    @Test
    fun convertsHundreds() {
        assertEquals("One Hundred Twenty Three", Solution().numberToWords(123))
    }

    @Test
    fun convertsThousands() {
        assertEquals("Twelve Thousand Three Hundred Forty Five", Solution().numberToWords(12345))
    }

    @Test
    fun skipsEmptyGroups() {
        assertEquals("One Million Ten", Solution().numberToWords(1000010))
        assertEquals("One Thousand", Solution().numberToWords(1000))
    }

    @Test
    fun convertsMaximumPositiveInt() {
        assertEquals(
            "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
            Solution().numberToWords(Int.MAX_VALUE)
        )
    }
}
