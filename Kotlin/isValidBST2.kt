package isValidBST2

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(logn)

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun isValidBST(root: TreeNode?, lower: Int, upper: Int): Boolean {
        if (root == null) {
            return true
        }
        return root.`val` > lower && root.`val` < upper &&
            isValidBST(root.left, lower, root.`val`) &&
            isValidBST(root.right, root.`val`, upper)
    }
}
