package patchingarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PatchingArrayTest {
    private val solution = Solution()

    @Test
    fun patchesMissingTwo() {
        assertEquals(1, solution.minPatches(intArrayOf(1, 3), 6))
    }

    @Test
    fun patchesTwoMissingValues() {
        assertEquals(2, solution.minPatches(intArrayOf(1, 5, 10), 20))
    }

    @Test
    fun handlesAlreadyCompleteRange() {
        assertEquals(0, solution.minPatches(intArrayOf(1, 2, 2), 5))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(1, solution.minPatches(IntArray(0), 1))
    }

    @Test
    fun ignoresValuesAboveTarget() {
        assertEquals(2, solution.minPatches(intArrayOf(7), 3))
    }
}
