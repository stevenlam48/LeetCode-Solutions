package maximumpalindromesafteroperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPalindromesAfterOperationsTest {
    @Test
    fun firstExample() {
        assertEquals(3, Solution().maxPalindromesAfterOperations(listOf("ababc", "a", "bc")))
    }

    @Test
    fun secondExample() {
        assertEquals(2, Solution().maxPalindromesAfterOperations(listOf("abcde", "ab", "a")))
    }

    @Test
    fun singleCharacterWordsAreAlreadyPalindromes() {
        assertEquals(3, Solution().maxPalindromesAfterOperations(listOf("a", "b", "c")))
    }

    @Test
    fun everyWordCanBePalindrome() {
        assertEquals(2, Solution().maxPalindromesAfterOperations(listOf("aa", "bb")))
    }
}
