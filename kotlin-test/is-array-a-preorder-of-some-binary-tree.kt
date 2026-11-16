package isarrayapreorderofsomebinarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsArrayAPreorderOfSomeBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun testValidChain() {
        val nodes = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )
        assertTrue(solution.isPreorder(nodes))
    }

    @Test
    fun testValidBranching() {
        val nodes = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 2),
            intArrayOf(4, 2)
        )
        assertTrue(solution.isPreorder(nodes))
    }

    @Test
    fun testSingleNode() {
        assertTrue(solution.isPreorder(arrayOf(intArrayOf(0, -1))))
    }

    @Test
    fun testParentNotAncestor() {
        val nodes = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(4, 1)
        )
        assertFalse(solution.isPreorder(nodes))
    }

    @Test
    fun testSelfParent() {
        val nodes = arrayOf(
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(2, 2)
        )
        assertFalse(solution.isPreorder(nodes))
    }
}
