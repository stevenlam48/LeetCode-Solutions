package minimumcosttomovebetweenindices

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumCostToMoveBetweenIndicesTest {
    private val solution = Solution()

    private fun arrayOfQueries(vararg queries: Pair<Int, Int>): Array<IntArray> {
        return Array(queries.size) { intArrayOf(queries[it].first, queries[it].second) }
    }

    @Test
    fun increasingArray() {
        val queries = arrayOfQueries(0 to 3, 3 to 0, 1 to 2)
        assertArrayEquals(intArrayOf(8, 3, 3), solution.minCost(intArrayOf(1, 3, 6, 10), queries))
    }

    @Test
    fun sameIndexHasZeroCost() {
        val queries = arrayOfQueries(0 to 0, 2 to 2)
        assertArrayEquals(intArrayOf(0, 0), solution.minCost(intArrayOf(1, 2, 4), queries))
    }

    @Test
    fun singleElement() {
        val queries = arrayOfQueries(0 to 0)
        assertArrayEquals(intArrayOf(0), solution.minCost(intArrayOf(5), queries))
    }

    @Test
    fun smallerExample() {
        val queries = arrayOfQueries(0 to 1, 1 to 2, 2 to 0)
        assertArrayEquals(intArrayOf(1, 2, 2), solution.minCost(intArrayOf(1, 2, 4), queries))
    }
}
