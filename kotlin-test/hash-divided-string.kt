package hashdividedstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HashDividedStringTest {
    private val solution = Solution()

    @Test
    fun multipleSubstrings() {
        assertEquals("bf", solution.stringHash("abcd", 2))
    }

    @Test
    fun hashWrapsAroundAlphabet() {
        assertEquals("i", solution.stringHash("mxz", 3))
    }

    @Test
    fun singleCharacterChunks() {
        assertEquals("leetcode", solution.stringHash("leetcode", 1))
    }

    @Test
    fun repeatedChunkHash() {
        assertEquals("gg", solution.stringHash("abcdabcd", 4))
    }
}
