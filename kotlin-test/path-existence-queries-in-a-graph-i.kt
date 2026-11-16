package pathexistencequeriesinagraphi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInAGraphITest {
    private val solution = Solution()

    @Test
    fun answersQueriesUsingConnectedPrefixComponents() {
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(4, 3)
        )
        assertArrayEquals(
            booleanArrayOf(true, true, false, false),
            solution.pathExistenceQueries(5, intArrayOf(2, 5, 6, 8, 12), 3, queries)
        )
    }

    @Test
    fun handlesSingleNode() {
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(
            booleanArrayOf(true),
            solution.pathExistenceQueries(1, intArrayOf(7), 0, queries)
        )
    }

    @Test
    fun answersReverseQueries() {
        val queries = arrayOf(intArrayOf(2, 0), intArrayOf(0, 1))
        assertArrayEquals(
            booleanArrayOf(true, true),
            solution.pathExistenceQueries(3, intArrayOf(1, 2, 4), 2, queries)
        )
    }
}
