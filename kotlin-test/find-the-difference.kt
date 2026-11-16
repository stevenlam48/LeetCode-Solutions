package findthedifference

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDifferenceTest {
    @Test
    fun findsAddedLetter() {
        assertEquals('e', Solution().findTheDifference("abcd", "abcde"))
    }

    @Test
    fun handlesEmptyOriginalString() {
        assertEquals('y', Solution().findTheDifference("", "y"))
    }

    @Test
    fun handlesDuplicateLetters() {
        assertEquals('a', Solution().findTheDifference("aabb", "ababa"))
    }

    @Test
    fun handlesRepeatedOriginalLetter() {
        assertEquals('a', Solution().findTheDifference("a", "aa"))
    }
}
