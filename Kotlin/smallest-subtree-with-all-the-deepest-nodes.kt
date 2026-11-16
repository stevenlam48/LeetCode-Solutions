package smallestsubtreewithallthedeepestnodes

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        return dfs(root).first
    }

    private fun dfs(node: TreeNode?): Pair<TreeNode?, Int> {
        if (node == null) {
            return Pair(null, 0)
        }
        val left = dfs(node.left)
        val right = dfs(node.right)
        if (left.second > right.second) {
            return Pair(left.first, left.second + 1)
        }
        if (left.second < right.second) {
            return Pair(right.first, right.second + 1)
        }
        return Pair(node, left.second + 1)
    }
}
