package flipcolumnsformaximumnumberofequalrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FlipColumnsForMaximumNumberOfEqualRowsTest {
    private val solution = Solution()

    @Test
    fun findsMaximumWhenOnlyOneEncodingMatches() {
        val matrix = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))

        assertEquals(1, solution.maxEqualRowsAfterFlips(matrix))
    }

    @Test
    fun combinesEqualAndComplementaryRows() {
        val matrix = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))

        assertEquals(2, solution.maxEqualRowsAfterFlips(matrix))
    }

    @Test
    fun selectsLargestEncodingGroup() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 0)
        )

        assertEquals(2, solution.maxEqualRowsAfterFlips(matrix))
    }

    @Test
    fun handlesSingleRowAndSingleColumn() {
        assertEquals(1, solution.maxEqualRowsAfterFlips(arrayOf(intArrayOf(0, 1, 0))))
        assertEquals(
            3,
            solution.maxEqualRowsAfterFlips(
                arrayOf(intArrayOf(0), intArrayOf(1), intArrayOf(1))
            )
        )
    }
}
