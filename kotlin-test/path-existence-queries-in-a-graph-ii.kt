package pathexistencequeriesinagraphii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInAGraphIITest {
    private val solution = Solution()

    @Test
    fun returnsMinimumMovesInBothDirections() {
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 0),
            intArrayOf(0, 4),
            intArrayOf(2, 2),
            intArrayOf(0, 1)
        )
        assertArrayEquals(
            intArrayOf(2, 2, -1, 0, 1),
            solution.pathExistenceQueries(5, intArrayOf(0, 1, 3, 6, 10), 2, queries)
        )
    }

    @Test
    fun handlesUnsortedNodeValues() {
        val queries = arrayOf(intArrayOf(3, 1), intArrayOf(2, 4))
        assertArrayEquals(
            intArrayOf(3, 2),
            solution.pathExistenceQueries(5, intArrayOf(4, 7, 6, 2, 9), 2, queries)
        )
    }

    @Test
    fun separatesDisconnectedNodes() {
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 2))
        assertArrayEquals(
            intArrayOf(-1, -1, 0),
            solution.pathExistenceQueries(3, intArrayOf(1, 5, 10), 1, queries)
        )
    }

    @Test
    fun handlesTwoConnectedNodes() {
        val queries = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(
            intArrayOf(1),
            solution.pathExistenceQueries(2, intArrayOf(1, 2), 1, queries)
        )
    }
}
