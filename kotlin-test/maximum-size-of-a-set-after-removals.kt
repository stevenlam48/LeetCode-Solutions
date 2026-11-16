package maximumsizeofasetafterremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSizeOfASetAfterRemovalsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maximumSetSize(intArrayOf(1, 2, 1, 2), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun disjointSets() {
        assertEquals(2, Solution().maximumSetSize(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    }

    @Test
    fun overlappingRanges() {
        assertEquals(6, Solution().maximumSetSize(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(2, 3, 4, 5, 6, 7)))
    }

    @Test
    fun allSame() {
        assertEquals(1, Solution().maximumSetSize(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().maximumSetSize(intArrayOf(1), intArrayOf(1)))
    }
}
