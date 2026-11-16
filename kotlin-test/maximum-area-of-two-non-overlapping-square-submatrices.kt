package maximumareaoftwononoverlappingsquaresubmatrices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAreaOfTwoNonOverlappingSquareSubmatricesTest {
    private val solution = Solution()

    @Test
    fun twoByTwoMatrixOnlyFitsUnitSquares() {
        assertEquals(1, solution.maxArea(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))))
    }

    @Test
    fun twoByFourMatrixFitsTwoSizedTwoSquares() {
        assertEquals(4, solution.maxArea(arrayOf(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 1))))
    }

    @Test
    fun wideMatrixFitsTwoSizedThreeSquares() {
        val mat = Array(3) { IntArray(6) { 1 } }
        assertEquals(9, solution.maxArea(mat))
    }

    @Test
    fun insufficientWidthForTwoLargeSquares() {
        assertEquals(1, solution.maxArea(Array(2) { IntArray(3) { 1 } }))
    }

    @Test
    fun allZeros() {
        assertEquals(0, solution.maxArea(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))))
    }

    @Test
    fun separatedUnitSquares() {
        val mat = arrayOf(intArrayOf(1, 1, 0, 1), intArrayOf(1, 1, 0, 1), intArrayOf(0, 0, 0, 0))
        assertEquals(1, solution.maxArea(mat))
    }
}
