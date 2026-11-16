package countunivaluesubtrees

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun countUnivalSubtrees(root: TreeNode?): Int {
        val count = IntArray(1)
        isUnivalSubtrees(root, count)
        return count[0]
    }

    private fun isUnivalSubtrees(root: TreeNode?, count: IntArray): Boolean {
        if (root == null) {
            return true
        }
        val left = isUnivalSubtrees(root.left, count)
        val right = isUnivalSubtrees(root.right, count)
        if (isSame(root, root.left, left) && isSame(root, root.right, right)) {
            ++count[0]
            return true
        }
        return false
    }

    private fun isSame(root: TreeNode, child: TreeNode?, isUni: Boolean): Boolean {
        return child == null || (isUni && root.`val` == child.`val`)
    }
}
