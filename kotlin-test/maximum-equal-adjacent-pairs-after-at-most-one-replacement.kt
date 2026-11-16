package maximumequaladjacentpairsafteratmostonereplacement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumEqualAdjacentPairsAfterAtMostOneReplacementTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxEqualAdjacentPairs(intArrayOf(1, 2, 3, 2)))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxEqualAdjacentPairs(intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().maxEqualAdjacentPairs(intArrayOf(1, 1, 1)))
    }

    @Test
    fun allDistinct() {
        assertEquals(1, Solution().maxEqualAdjacentPairs(intArrayOf(1, 2, 3)))
    }

    @Test
    fun twoBlocks() {
        assertEquals(3, Solution().maxEqualAdjacentPairs(intArrayOf(1, 1, 2, 2)))
    }

    @Test
    fun alternating() {
        assertEquals(3, Solution().maxEqualAdjacentPairs(intArrayOf(1, 2, 1, 2)))
    }
}
