package substringsofsizethreewithdistinctcharacters

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubstringsOfSizeThreeWithDistinctCharactersTest {
    @Test
    fun exampleOne() {
        assertEquals(1, Solution().countGoodSubstrings("xyzzaz"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(4, Solution().countGoodSubstrings("aababcabc"))
    }

    @Test
    fun repeatedCharacters() {
        assertEquals(0, Solution().countGoodSubstrings("aaaaaa"))
    }

    @Test
    fun shortAndExactlyThreeCharacters() {
        assertEquals(0, Solution().countGoodSubstrings("ab"))
        assertEquals(1, Solution().countGoodSubstrings("abc"))
        assertEquals(0, Solution().countGoodSubstrings("aba"))
    }
}
