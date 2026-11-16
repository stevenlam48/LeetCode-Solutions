package findthedegreeofeachvertex

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDegreeOfEachVertexTest {
    @Test
    fun sumsAdjacencyMatrixRows() {
        val matrix = arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 0, 0), intArrayOf(1, 0, 0))
        assertArrayEquals(intArrayOf(2, 1, 1), Solution().findDegrees(matrix))
    }

    @Test
    fun handlesEmptyMatrix() {
        assertArrayEquals(intArrayOf(), Solution().findDegrees(arrayOf()))
    }

    @Test
    fun matchesRowSumSemanticsForSelfLoop() {
        val matrix = arrayOf(intArrayOf(1, 0), intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(1, 0), Solution().findDegrees(matrix))
    }
}
