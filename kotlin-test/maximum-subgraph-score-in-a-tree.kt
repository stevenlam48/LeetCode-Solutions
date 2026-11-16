package maximumsubgraphscoreinatree
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MaximumSubgraphScoreInATreeTest {
    private val solution = Solution()

    @Test
    fun singleGoodNode() {
        assertArrayEquals(intArrayOf(1), solution.maxSubgraphScore(1, emptyArray(), intArrayOf(1)))
    }

    @Test
    fun singleBadNode() {
        assertArrayEquals(intArrayOf(-1), solution.maxSubgraphScore(1, emptyArray(), intArrayOf(0)))
    }

    @Test
    fun lineTree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(
            intArrayOf(0, 1, 0),
            solution.maxSubgraphScore(3, edges, intArrayOf(0, 1, 0))
        )
    }

    @Test
    fun allBadTree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertArrayEquals(
            intArrayOf(-1, -1, -1),
            solution.maxSubgraphScore(3, edges, intArrayOf(0, 0, 0))
        )
    }

    @Test
    fun goodSubtreeCanBeExcluded() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 4)
        )
        assertArrayEquals(
            intArrayOf(0, -1, 1, -1, -1),
            solution.maxSubgraphScore(5, edges, intArrayOf(0, 0, 1, 0, 0))
        )
    }
}
