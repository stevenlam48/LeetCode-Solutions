package increasingordersearchtree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun increasingBST(root: TreeNode?): TreeNode? {
        return increasingBSTHelper(root, null)
    }

    private fun increasingBSTHelper(root: TreeNode?, tail: TreeNode?): TreeNode? {
        if (root == null) {
            return tail
        }
        val result = increasingBSTHelper(root.left, root)
        root.left = null
        root.right = increasingBSTHelper(root.right, tail)
        return result
    }
}
