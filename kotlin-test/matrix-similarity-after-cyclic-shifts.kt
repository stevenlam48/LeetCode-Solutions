package matrixsimilarityaftercyclicshifts

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MatrixSimilarityAfterCyclicShiftsTest {
    private val solution = Solution()

    @Test
    fun returnsTrueWhenEachRowIsInvariantUnderShift() {
        val mat = arrayOf(intArrayOf(1, 2, 1, 2), intArrayOf(5, 5, 5, 5), intArrayOf(6, 3, 6, 3))
        assertTrue(solution.areSimilar(mat, 2))
    }

    @Test
    fun returnsFalseForChangedRow() {
        val mat = arrayOf(intArrayOf(2, 2), intArrayOf(2, 3))
        assertFalse(solution.areSimilar(mat, 1))
    }

    @Test
    fun zeroShiftAlwaysPreservesMatrix() {
        val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertTrue(solution.areSimilar(mat, 0))
    }

    @Test
    fun acceptsShiftEqualToFullCycle() {
        val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        assertTrue(solution.areSimilar(mat, 3))
    }

    @Test
    fun handlesSingleColumn() {
        assertTrue(solution.areSimilar(arrayOf(intArrayOf(4), intArrayOf(7)), 5))
    }
}
