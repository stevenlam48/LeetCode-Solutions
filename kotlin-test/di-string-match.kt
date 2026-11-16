package distringmatch

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DiStringMatchTest {
    private val solution = Solution()

    @Test
    fun mixedDirectionsMatch() {
        assertArrayEquals(intArrayOf(0, 4, 1, 3, 2), solution.diStringMatch("IDID"))
    }

    @Test
    fun decreasingStartAndIncreasingEndMatch() {
        assertArrayEquals(intArrayOf(0, 1, 2, 3), solution.diStringMatch("III"))
        assertArrayEquals(intArrayOf(3, 2, 1, 0), solution.diStringMatch("DDD"))
    }

    @Test
    fun arbitraryValidPermutationIsAccepted() {
        assertArrayEquals(intArrayOf(3, 2, 0, 1), solution.diStringMatch("DDI"))
    }

    @Test
    fun emptyPatternReturnsZero() {
        assertArrayEquals(intArrayOf(0), solution.diStringMatch(""))
    }
}
