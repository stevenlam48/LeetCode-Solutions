package kthlargestperfectsubtreesizeinbinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val nodes = arrayOfNulls<TreeNode>(values.size)
    for (i in values.indices) {
        nodes[i] = values[i]?.let { TreeNode(it) }
    }
    for (i in values.indices) {
        if (2 * i + 1 < values.size) {
            nodes[i]?.left = nodes[2 * i + 1]
        }
        if (2 * i + 2 < values.size) {
            nodes[i]?.right = nodes[2 * i + 2]
        }
    }
    return nodes[0]
}

class KThLargestPerfectSubtreeSizeInBinaryTreeTest {
    @Test
    fun `perfect root has largest subtree`() {
        assertEquals(3, Solution().kthLargestPerfectSubtree(treeOf(2, 1, 3), 1))
    }

    @Test
    fun `leaf subtrees rank after their parent`() {
        val root = treeOf(2, 1, 3)
        assertEquals(1, Solution().kthLargestPerfectSubtree(root, 2))
        assertEquals(1, Solution().kthLargestPerfectSubtree(root, 3))
    }

    @Test
    fun `imperfect root still contains perfect leaf`() {
        assertEquals(1, Solution().kthLargestPerfectSubtree(treeOf(1, 2), 1))
    }

    @Test
    fun `larger perfect tree has repeated perfect sizes`() {
        val root = treeOf(4, 2, 6, 1, 3, 5, 7)
        assertEquals(7, Solution().kthLargestPerfectSubtree(root, 1))
        assertEquals(3, Solution().kthLargestPerfectSubtree(root, 2))
        assertEquals(1, Solution().kthLargestPerfectSubtree(root, 4))
    }

    @Test
    fun `returns minus one for null entries or excessive k`() {
        assertEquals(-1, Solution().kthLargestPerfectSubtree(treeOf(2, 1, 3), 4))
        assertEquals(-1, Solution().kthLargestPerfectSubtree(null, 1))
        assertEquals(-1, Solution().kthLargestPerfectSubtree(treeOf(1), 100))
    }
}
