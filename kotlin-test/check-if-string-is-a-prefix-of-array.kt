package checkifstringisaprefixofarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringIsAPrefixOfArrayTest {
    private val solution = Solution()

    @Test
    fun exactWholeWordPrefix() {
        assertTrue(solution.isPrefixString(
            "iloveleetcode",
            listOf("i", "love", "leetcode", "apples")
        ))
    }

    @Test
    fun firstWordDoesNotMatch() {
        assertFalse(solution.isPrefixString(
            "iloveleetcode",
            listOf("apples", "i", "love", "leetcode")
        ))
    }

    @Test
    fun stringEndsInsideWord() {
        assertFalse(solution.isPrefixString("a", listOf("aa", "bb")))
    }

    @Test
    fun singleExactWord() {
        assertTrue(solution.isPrefixString("a", listOf("a")))
    }

    @Test
    fun emptyStringEndsAtWordBoundary() {
        assertTrue(solution.isPrefixString("", listOf("word")))
    }
}
