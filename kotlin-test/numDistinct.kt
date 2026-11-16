package numDistinct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumDistinctTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().numDistinct("rabbbit", "rabbit"))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().numDistinct("babgbag", "bag"))
    }

    @Test
    fun singleMatchingChar() {
        assertEquals(1, Solution().numDistinct("a", "a"))
    }

    @Test
    fun singleNonMatchingChar() {
        assertEquals(0, Solution().numDistinct("a", "b"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(3, Solution().numDistinct("aaa", "aa"))
    }

    @Test
    fun emptyStrings() {
        assertEquals(1, Solution().numDistinct("", ""))
    }
}
