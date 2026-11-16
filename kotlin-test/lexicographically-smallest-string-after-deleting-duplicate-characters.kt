package lexicographicallysmalleststringafterdeletingduplicatecharacters

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterDeletingDuplicateCharactersTest {
    private val solution = Solution()

    @Test
    fun removesEarlierDuplicatesToPlaceSmallerCharacterFirst() {
        assertEquals("abc", solution.lexSmallestAfterDeletion("bcabc"))
    }

    @Test
    fun retainsDuplicatesWhenTheyImproveLexicographicalOrder() {
        assertEquals("acab", solution.lexSmallestAfterDeletion("bbacab"))
    }

    @Test
    fun removesTrailingRepeatedCharacter() {
        assertEquals("a", solution.lexSmallestAfterDeletion("aa"))
    }

    @Test
    fun preservesAlreadyOrderedDistinctCharacters() {
        assertEquals("ab", solution.lexSmallestAfterDeletion("ab"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertEquals("a", solution.lexSmallestAfterDeletion("a"))
    }
}
