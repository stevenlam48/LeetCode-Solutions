package longestzigzagpathinabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun longestZigZag(root: TreeNode?): Int {
        val result = intArrayOf(0)
        dfs(root, result)
        return result[0]
    }

    fun dfs(node: TreeNode?, result: IntArray): Pair<Int, Int> {
        if (node == null) {
            return Pair(-1, -1)
        }
        val left = dfs(node.left, result)
        val right = dfs(node.right, result)
        result[0] = maxOf(result[0], left.second + 1, right.first + 1)
        return Pair(left.second + 1, right.first + 1)
    }
}
