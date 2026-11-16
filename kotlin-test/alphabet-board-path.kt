package alphabetboardpath

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlphabetBoardPathTest {
    @Test
    fun testExampleLeet() {
        assertEquals("RDD!UURRR!!DDD!", Solution().alphabetBoardPath("leet"))
    }

    @Test
    fun testExampleCode() {
        assertEquals("RR!RRDD!UUL!R!", Solution().alphabetBoardPath("code"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("!", Solution().alphabetBoardPath("a"))
        assertEquals("DDDDD!", Solution().alphabetBoardPath("z"))
    }

    @Test
    fun testRepeatedCharacter() {
        assertEquals("DDDDD!!", Solution().alphabetBoardPath("zz"))
    }
}
