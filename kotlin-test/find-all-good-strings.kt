package findallgoodstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindAllGoodStringsTest {
    @Test
    fun example1() {
        assertEquals(51, Solution().findGoodStrings(2, "aa", "da", "b"))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().findGoodStrings(8, "leetcode", "leetgoes", "leet"))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().findGoodStrings(2, "gx", "gz", "x"))
    }

    @Test
    fun singleCharacterRange() {
        assertEquals(25, Solution().findGoodStrings(1, "a", "z", "a"))
    }

    @Test
    fun singleCharacterExact() {
        assertEquals(1, Solution().findGoodStrings(1, "a", "a", "b"))
    }

    @Test
    fun singleCharacterBlocked() {
        assertEquals(0, Solution().findGoodStrings(1, "a", "a", "a"))
    }
}
