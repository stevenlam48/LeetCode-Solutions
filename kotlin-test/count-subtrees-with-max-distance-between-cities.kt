package countsubtreeswithmaxdistancebetweencities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubtreesWithMaxDistanceBetweenCitiesTest {
    private val solution = Solution()

    @Test
    fun `counts star graph subgraphs`() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(2, 4))
        assertArrayEquals(intArrayOf(3, 4, 0), solution.countSubgraphsForEachDiameter(4, edges))
    }

    @Test
    fun `counts chain graph subgraphs`() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
        assertArrayEquals(intArrayOf(3, 2, 1), solution.countSubgraphsForEachDiameter(4, edges))
    }

    @Test
    fun `handles three cities`() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(2, 1), solution.countSubgraphsForEachDiameter(3, edges))
    }

    @Test
    fun `handles a single edge`() {
        assertArrayEquals(intArrayOf(1), solution.countSubgraphsForEachDiameter(2, arrayOf(intArrayOf(1, 2))))
    }
}
