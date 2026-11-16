package verifyinganaliendictionary

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VerifyingAnAlienDictionaryTest {
    private val solution = Solution()

    @Test
    fun acceptsSortedWords() {
        assertTrue(solution.isAlienSorted(listOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
    }

    @Test
    fun rejectsIncorrectLetterOrder() {
        assertFalse(solution.isAlienSorted(listOf("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"))
    }

    @Test
    fun rejectsLongerPrefixBeforeShorterWord() {
        assertFalse(solution.isAlienSorted(listOf("apple", "app"), "abcdefghijklmnopqrstuvwxyz"))
        assertTrue(solution.isAlienSorted(listOf("app", "apple"), "abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun handlesSingleAndDuplicateWords() {
        assertTrue(solution.isAlienSorted(listOf("word"), "abcdefghijklmnopqrstuvwxyz"))
        assertTrue(solution.isAlienSorted(listOf("a", "a", "a"), "abcdefghijklmnopqrstuvwxyz"))
    }
}
