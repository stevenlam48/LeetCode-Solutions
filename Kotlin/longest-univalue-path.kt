package longestunivaluepath

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun longestUnivaluePath(root: TreeNode?): Int {
        val result = intArrayOf(0)
        dfs(root, result)
        return result[0]
    }

    private fun dfs(node: TreeNode?, result: IntArray): Int {
        if (node == null) {
            return 0
        }
        var left = dfs(node.left, result)
        var right = dfs(node.right, result)
        left = if (node.left != null && node.`val` == node.left!!.`val`) left + 1 else 0
        right = if (node.right != null && node.`val` == node.right!!.`val`) right + 1 else 0
        result[0] = maxOf(result[0], left + right)
        return maxOf(left, right)
    }
}
