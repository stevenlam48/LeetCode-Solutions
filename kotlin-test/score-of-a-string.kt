package scoreofastring

// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreOfAStringTest {
    @Test
    fun hello() {
        assertEquals(13, Solution().scoreOfString("hello"))
    }

    @Test
    fun alternatingEnds() {
        assertEquals(50, Solution().scoreOfString("zaz"))
    }

    @Test
    fun emptyAndSingleCharacter() {
        assertEquals(0, Solution().scoreOfString(""))
        assertEquals(0, Solution().scoreOfString("a"))
    }

    @Test
    fun equalCharacters() {
        assertEquals(0, Solution().scoreOfString("aaaa"))
    }
}
