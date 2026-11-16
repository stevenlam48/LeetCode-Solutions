package minimizeinversionsinaprefixtree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeInversionsInAPrefixTreeTest {
    private val solution = Solution()

    @Test
    fun singleWordHasNoInversions() {
        assertEquals(0, solution.minInversions(listOf("abc"), intArrayOf(0)))
    }

    @Test
    fun siblingSubtreesCanBeReorderedFreely() {
        assertEquals(0, solution.minInversions(listOf("a", "b"), intArrayOf(1, 0)))
        assertEquals(0, solution.minInversions(listOf("ab", "ac"), intArrayOf(1, 0)))
    }

    @Test
    fun nestedWordsHaveFixedPrefixOrder() {
        assertEquals(1, solution.minInversions(listOf("a", "aa"), intArrayOf(1, 0)))
        assertEquals(0, solution.minInversions(listOf("a", "aa"), intArrayOf(0, 1)))
    }

    @Test
    fun disjointSubtreeRangesHaveNoForcedInversions() {
        assertEquals(
            0,
            solution.minInversions(listOf("aa", "ab", "ba", "bb"), intArrayOf(0, 1, 2, 3))
        )
    }

    @Test
    fun interleavedSubtreeRangesForceOneInversion() {
        assertEquals(
            1,
            solution.minInversions(listOf("aa", "ab", "ba", "bb"), intArrayOf(0, 2, 1, 3))
        )
    }
}
