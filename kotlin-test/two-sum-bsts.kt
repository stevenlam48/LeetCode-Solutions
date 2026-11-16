package twosumbsts

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoSumBstsTest {
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
        assertTrue(Solution().twoSumBSTs(bst(2, 1, 4), bst(1, 4), 5))
    }

    @Test
    fun exampleFalse() {
        assertFalse(Solution().twoSumBSTs(bst(2, 1, 4), bst(1, 4), 4))
    }

    @Test
    fun maxSum() {
        assertTrue(Solution().twoSumBSTs(bst(2, 1, 4), bst(1, 4), 8))
    }

    @Test
    fun singleNodes() {
        assertTrue(Solution().twoSumBSTs(bst(1), bst(2), 3))
        assertFalse(Solution().twoSumBSTs(bst(1), bst(2), 4))
    }
}
