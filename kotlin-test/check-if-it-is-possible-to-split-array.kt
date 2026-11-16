package checkifitispossibletosplitarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfItIsPossibleToSplitArrayTest {
    private val solution = Solution()

    @Test
    fun firstPairIsLargeEnough() {
        assertTrue(solution.canSplitArray(intArrayOf(2, 2, 3), 5))
    }

    @Test
    fun noPairIsLargeEnough() {
        assertFalse(solution.canSplitArray(intArrayOf(2, 1, 3), 5))
    }

    @Test
    fun twoElementsAlwaysSplit() {
        assertTrue(solution.canSplitArray(intArrayOf(1, 1), 100))
    }

    @Test
    fun singleElementAlwaysSplits() {
        assertTrue(solution.canSplitArray(intArrayOf(1), 10))
    }

    @Test
    fun qualifyingPairAtEnd() {
        assertTrue(solution.canSplitArray(intArrayOf(1, 1, 4, 4), 8))
    }
}
