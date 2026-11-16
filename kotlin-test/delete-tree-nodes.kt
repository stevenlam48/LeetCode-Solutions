package deletetreenodes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeleteTreeNodesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            2,
            solution.deleteTreeNodes(7, intArrayOf(-1, 0, 0, 1, 2, 2, 2), intArrayOf(1, -2, 4, 0, -2, -1, -1))
        )
    }

    @Test
    fun testAllPositive() {
        assertEquals(3, solution.deleteTreeNodes(3, intArrayOf(-1, 0, 1), intArrayOf(1, 2, 3)))
    }

    @Test
    fun testRootZero() {
        assertEquals(0, solution.deleteTreeNodes(3, intArrayOf(-1, 0, 1), intArrayOf(1, 2, -3)))
    }

    @Test
    fun testSingleNodePositive() {
        assertEquals(1, solution.deleteTreeNodes(1, intArrayOf(-1), intArrayOf(5)))
    }

    @Test
    fun testSingleNodeZero() {
        assertEquals(0, solution.deleteTreeNodes(1, intArrayOf(-1), intArrayOf(0)))
    }

    @Test
    fun testSubtreeRemoved() {
        // 0 -> 1 -> 2, values 1, -1, 0: node2 total 0 removed, node1 total -1 removed, root total 0
        assertEquals(0, solution.deleteTreeNodes(3, intArrayOf(-1, 0, 1), intArrayOf(1, -1, 0)))
    }
}
