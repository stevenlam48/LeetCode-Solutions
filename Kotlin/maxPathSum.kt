package maxPathSum

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(logn)

class Solution {
    private var maxSum = 0

    fun maxPathSum(root: TreeNode?): Int {
        maxSum = Int.MIN_VALUE
        dfs(root)
        return maxSum
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val l = dfs(root.left)
        val r = dfs(root.right)
        var sum = root.`val`
        if (l > 0) sum += l
        if (r > 0) sum += r
        maxSum = maxOf(maxSum, sum)
        return if (maxOf(r, l) > 0) maxOf(r, l) + root.`val` else root.`val`
    }
}
