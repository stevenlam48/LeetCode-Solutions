package sumofmatrixafterqueries

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfMatrixAfterQueriesTest {
    private val solution = Solution()

    @Test
    fun exampleQueries() {
        val queries = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(0, 2, 3),
            intArrayOf(1, 0, 4)
        )
        assertEquals(23L, solution.matrixSumQueries(3, queries))
    }

    @Test
    fun emptyQueries() {
        assertEquals(0L, solution.matrixSumQueries(3, emptyArray()))
    }

    @Test
    fun lastUpdateToSingleCellWins() {
        val queries = arrayOf(
            intArrayOf(0, 0, 5),
            intArrayOf(1, 0, 7),
            intArrayOf(0, 0, 9)
        )
        assertEquals(9L, solution.matrixSumQueries(1, queries))
    }

    @Test
    fun rowAndColumnOverlap() {
        val queries = arrayOf(
            intArrayOf(0, 0, 5),
            intArrayOf(1, 1, 2)
        )
        assertEquals(9L, solution.matrixSumQueries(2, queries))
    }
}
