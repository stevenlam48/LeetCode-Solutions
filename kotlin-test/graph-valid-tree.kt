package graphvalidtree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GraphValidTreeTest {
    @Test
    fun `valid standard example`() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 4))
        assertTrue(Solution().validTree(5, edges))
    }

    @Test
    fun `cycle is invalid`() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(1, 4))
        assertFalse(Solution().validTree(5, edges))
    }

    @Test
    fun `wrong edge count and disconnected graph`() {
        val solution = Solution()
        assertFalse(solution.validTree(4, arrayOf(intArrayOf(0, 1), intArrayOf(2, 3))))
        assertFalse(solution.validTree(3, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun `single isolated vertex is a tree`() {
        assertTrue(Solution().validTree(1, arrayOf()))
    }
}
