package lexicographicallysmalleststringafteradjacentremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterAdjacentRemovalsTest {
    private val solution = Solution()

    @Test
    fun choosesSmallestResultAmongAlternativeRemovals() {
        assertEquals("a", solution.lexicographicallySmallestString("abc"))
        assertEquals("a", solution.lexicographicallySmallestString("cba"))
    }

    @Test
    fun removesWraparoundAdjacentLetters() {
        assertEquals("", solution.lexicographicallySmallestString("za"))
    }

    @Test
    fun chainsRemovalsAfterInnerPairDisappears() {
        assertEquals("", solution.lexicographicallySmallestString("dbac"))
    }

    @Test
    fun removesEntireStringThroughNestedAdjacentPairs() {
        assertEquals("", solution.lexicographicallySmallestString("cbad"))
    }

    @Test
    fun leavesNonAdjacentIdenticalLettersUnchanged() {
        assertEquals("zz", solution.lexicographicallySmallestString("zz"))
    }

    @Test
    fun handlesEmptyString() {
        assertEquals("", solution.lexicographicallySmallestString(""))
    }
}
