package maximumproductofsplittedbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun maxProduct(root: TreeNode?): Int {
        val MOD = 1_000_000_007L
        val result = LongArray(1)
        dfs(root, dfs(root, 0L, result), result)
        return (result[0] % MOD).toInt()
    }

    private fun dfs(root: TreeNode?, total: Long, result: LongArray): Long {
        if (root == null) {
            return 0
        }
        val subtotal = dfs(root.left, total, result) +
            dfs(root.right, total, result) +
            root.`val`
        result[0] = maxOf(result[0], subtotal * (total - subtotal))
        return subtotal
    }
}
