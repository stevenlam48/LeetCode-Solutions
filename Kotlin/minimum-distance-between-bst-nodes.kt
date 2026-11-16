package minimumdistancebetweenbstnodes
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun minDiffInBST(root: TreeNode?): Int {
        val prev = intArrayOf(Int.MIN_VALUE)
        val result = intArrayOf(Int.MAX_VALUE)
        dfs(root, prev, result)
        return result[0]
    }

    private fun dfs(node: TreeNode?, prev: IntArray, result: IntArray) {
        if (node == null) {
            return
        }
        dfs(node.left, prev, result)
        if (prev[0] != Int.MIN_VALUE) {
            result[0] = minOf(result[0], node.`val` - prev[0])
        }
        prev[0] = node.`val`
        dfs(node.right, prev, result)
    }
}
