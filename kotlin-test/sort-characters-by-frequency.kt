package sortcharactersbyfrequency

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortCharactersByFrequencyTest {
    @Test
    fun repeatedCharacterHasHighestFrequency() {
        val result = Solution().frequencySort("tree")
        assertTrue(result == "eert" || result == "eetr")
    }

    @Test
    fun equalFrequenciesMayUseEitherOrder() {
        val result = Solution().frequencySort("cccaaa")
        assertTrue(result == "cccaaa" || result == "aaaccc")
    }

    @Test
    fun mixedCaseCharactersAreDistinct() {
        val result = Solution().frequencySort("Aabb")
        assertEquals("bb", result.substring(0, 2))
        assertEquals(setOf('A', 'a'), result.substring(2).toSet())
    }

    @Test
    fun emptyAndSingleCharacterStrings() {
        assertEquals("", Solution().frequencySort(""))
        assertEquals("x", Solution().frequencySort("x"))
    }

    @Test
    fun allCharactersHaveEqualFrequency() {
        val result = Solution().frequencySort("abcd")
        assertEquals(4, result.length)
        assertEquals(setOf('a', 'b', 'c', 'd'), result.toSet())
    }
}
