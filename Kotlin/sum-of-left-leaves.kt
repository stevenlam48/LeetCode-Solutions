package sumofleftleaves

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return sumOfLeftLeavesHelper(root, false)
    }

    private fun sumOfLeftLeavesHelper(root: TreeNode?, isLeft: Boolean): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            return if (isLeft) root.`val` else 0
        }
        return sumOfLeftLeavesHelper(root.left, true) +
            sumOfLeftLeavesHelper(root.right, false)
    }
}
