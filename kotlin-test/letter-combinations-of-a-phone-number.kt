package lettercombinationsofaphonenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LetterCombinationsOfAPhoneNumberTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
            Solution().letterCombinations("23")
        )
    }

    @Test
    fun emptyDigits() {
        assertEquals(emptyList<String>(), Solution().letterCombinations(""))
    }

    @Test
    fun singleDigit2() {
        assertEquals(listOf("a", "b", "c"), Solution().letterCombinations("2"))
    }

    @Test
    fun fourLetterDigit() {
        assertEquals(listOf("w", "x", "y", "z"), Solution().letterCombinations("9"))
    }
}
