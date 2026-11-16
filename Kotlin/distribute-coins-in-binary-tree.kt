package distributecoinsinbinarytree
// Time:  O(n)
// Space: O(h)

import common.TreeNode
import kotlin.math.abs

class Solution {
    fun distributeCoins(root: TreeNode?): Int {
        val result = IntArray(1)
        dfs(root, result)
        return result[0]
    }

    private fun dfs(root: TreeNode?, result: IntArray): Int {
        if (root == null) {
            return 0
        }
        val left = dfs(root.left, result)
        val right = dfs(root.right, result)
        result[0] += abs(left) + abs(right)
        return root.`val` + left + right - 1
    }
}
