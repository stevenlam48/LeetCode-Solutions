package minimumnumberofremovalstomakemountainarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfRemovalsToMakeMountainArrayTest {
    private val solution = Solution()

    @Test
    fun shortestMountainRequiresNoRemovals() {
        assertEquals(0, solution.minimumMountainRemovals(intArrayOf(1, 3, 1)))
    }

    @Test
    fun leetCodeExampleWithMultipleRemovals() {
        assertEquals(3, solution.minimumMountainRemovals(intArrayOf(2, 1, 1, 5, 6, 2, 3, 1)))
    }

    @Test
    fun symmetricMountainRequiresNoRemovals() {
        assertEquals(0, solution.minimumMountainRemovals(intArrayOf(1, 2, 3, 4, 3, 2, 1)))
    }

    @Test
    fun duplicateOnIncreasingSideMustBeRemoved() {
        assertEquals(1, solution.minimumMountainRemovals(intArrayOf(1, 2, 2, 3, 1)))
    }
}
