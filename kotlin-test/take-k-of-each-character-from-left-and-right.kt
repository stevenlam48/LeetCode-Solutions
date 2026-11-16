package takekofeachcharacterfromleftandright

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TakeKOfEachCharacterFromLeftAndRightTest {
    @Test
    fun standardExample() {
        assertEquals(8, Solution().takeCharacters("aabaaaacaabc", 2))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().takeCharacters("a", 1))
        assertEquals(-1, Solution().takeCharacters("aabaaa", 2))
    }

    @Test
    fun zeroRequired() {
        assertEquals(0, Solution().takeCharacters("abcabc", 0))
        assertEquals(0, Solution().takeCharacters("", 0))
    }

    @Test
    fun takeAllCharacters() {
        assertEquals(6, Solution().takeCharacters("aabbcc", 2))
    }
}
