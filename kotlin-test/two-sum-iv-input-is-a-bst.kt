package twosumivinputisabst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoSumIvInputIsABstTest {
    private fun bst(vararg values: Int): TreeNode? {
        var root: TreeNode? = null
        for (v in values) {
            root = insert(root, v)
        }
        return root
    }

    private fun insert(node: TreeNode?, v: Int): TreeNode {
        if (node == null) {
            return TreeNode(v)
        }
        if (v < node.`val`) {
            node.left = insert(node.left, v)
        } else {
            node.right = insert(node.right, v)
        }
        return node
    }

    @Test
    fun exampleTrue() {
        assertTrue(Solution().findTarget(bst(5, 3, 6, 2, 4, 7), 9))
    }

    @Test
    fun exampleFalse() {
        assertFalse(Solution().findTarget(bst(5, 3, 6, 2, 4, 7), 28))
    }

    @Test
    fun singleNode() {
        assertFalse(Solution().findTarget(bst(1), 2))
    }

    @Test
    fun usesSameNodeOnlyOnce() {
        assertFalse(Solution().findTarget(bst(2), 4))
    }
}
