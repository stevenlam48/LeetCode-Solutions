package lettercasepermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LetterCasePermutationTest {
    @Test
    fun example1() {
        assertEquals(
            listOf("a1b2", "A1b2", "a1B2", "A1B2"),
            Solution().letterCasePermutation("a1b2")
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("3z4", "3Z4"),
            Solution().letterCasePermutation("3z4")
        )
    }

    @Test
    fun allLetters() {
        assertEquals(
            listOf("abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"),
            Solution().letterCasePermutation("abc")
        )
    }

    @Test
    fun digitsOnly() {
        assertEquals(listOf("123"), Solution().letterCasePermutation("123"))
    }
}
