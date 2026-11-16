package splitastringintothemaxnumberofuniquesubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SplitAStringIntoTheMaxNumberOfUniqueSubstringsTest {
    @Test
    fun exampleOne() {
        assertEquals(5, Solution().maxUniqueSplit("ababccc"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, Solution().maxUniqueSplit("aba"))
    }

    @Test
    fun allSameCharacter() {
        assertEquals(1, Solution().maxUniqueSplit("aa"))
    }

    @Test
    fun allDistinctCharacters() {
        assertEquals(6, Solution().maxUniqueSplit("abcdef"))
    }

    @Test
    fun singleCharacter() {
        assertEquals(1, Solution().maxUniqueSplit("a"))
    }
}
