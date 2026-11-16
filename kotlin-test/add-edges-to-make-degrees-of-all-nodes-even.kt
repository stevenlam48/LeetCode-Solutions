package addedgestomakedegreesofallnodeseven

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AddEdgesToMakeDegreesOfAllNodesEvenTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val edges = arrayOf(
            intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4),
            intArrayOf(4, 2), intArrayOf(1, 4), intArrayOf(2, 5)
        )
        assertTrue(solution.isPossible(5, edges))
    }

    @Test
    fun twoDisconnectedEdges() {
        assertTrue(solution.isPossible(4, arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    fun threeEdgesAtOneNode() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4))
        assertFalse(solution.isPossible(4, edges))
    }

    @Test
    fun noEdges() {
        assertTrue(solution.isPossible(3, emptyArray()))
    }

    @Test
    fun twoOddVerticesWithCommonNonneighbors() {
        assertTrue(solution.isPossible(3, arrayOf(intArrayOf(1, 2))))
    }
}
