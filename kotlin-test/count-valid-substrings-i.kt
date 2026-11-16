package countvalidsubstringsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountValidSubstringsITest {
    @Test
    fun example1() {
        assertEquals(10L, Solution().countValidSubstrings("abac"))
    }

    @Test
    fun example2() {
        assertEquals(5L, Solution().countValidSubstrings("abc"))
    }

    @Test
    fun example3() {
        assertEquals(3L, Solution().countValidSubstrings("ac"))
    }

    @Test
    fun twoOccurrences() {
        assertEquals(14L, Solution().countValidSubstrings("abcabc"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1L, Solution().countValidSubstrings("a"))
    }
}
