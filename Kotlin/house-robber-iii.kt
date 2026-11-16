package houserobberiii
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun rob(root: TreeNode?): Int {
        val res = robHelper(root)
        return maxOf(res.first, res.second)
    }

    private fun robHelper(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return 0 to 0
        }
        val left = robHelper(root.left)
        val right = robHelper(root.right)
        return root.`val` + left.second + right.second to
            maxOf(left.first, left.second) + maxOf(right.first, right.second)
    }
}
