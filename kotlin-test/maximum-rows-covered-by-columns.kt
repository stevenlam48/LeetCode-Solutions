package maximumrowscoveredbycolumns

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumRowsCoveredByColumnsTest {
    private val solution = Solution()

    @Test
    fun findsBestPairOfColumns() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 0, 1)
        )

        assertEquals(3, solution.maximumRows(matrix, 2))
    }

    @Test
    fun singleColumnCanCoverEveryRow() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(0)
        )

        assertEquals(2, solution.maximumRows(matrix, 1))
    }

    @Test
    fun allZeroRowsAreAlwaysCovered() {
        val matrix = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        assertEquals(3, solution.maximumRows(matrix, 1))
    }

    @Test
    fun selectingAllColumnsCoversAllRows() {
        val matrix = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )

        assertEquals(2, solution.maximumRows(matrix, 2))
    }
}
