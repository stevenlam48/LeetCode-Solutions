package findthelexicographicallysmallestvalidsequence

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheLexicographicallySmallestValidSequenceTest {
    @Test
    fun exampleOneSubstitution() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().validSequence("vbcca", "abc"))
    }

    @Test
    fun substitutionInMiddle() {
        assertArrayEquals(intArrayOf(1, 2, 4), Solution().validSequence("bacdc", "abc"))
    }

    @Test
    fun exactSubsequence() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().validSequence("abc", "abc"))
    }

    @Test
    fun repeatedCharacters() {
        assertArrayEquals(intArrayOf(0, 1), Solution().validSequence("aaaa", "aa"))
    }

    @Test
    fun changesLastCharacter() {
        assertArrayEquals(intArrayOf(0, 1, 2), Solution().validSequence("abca", "abd"))
    }
}
