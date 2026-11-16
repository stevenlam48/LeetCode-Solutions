package maximumwidthofbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val leftmosts = ArrayList<Int>()
        return dfs(root, 1, 0, leftmosts)
    }

    private fun dfs(node: TreeNode?, id: Int, depth: Int, leftmosts: MutableList<Int>): Int {
        if (node == null) {
            return 0
        }
        if (depth >= leftmosts.size) {
            leftmosts.add(id)
        }
        var result = id - leftmosts[depth] + 1
        result = maxOf(result, dfs(node.left, id * 2, depth + 1, leftmosts))
        result = maxOf(result, dfs(node.right, id * 2 + 1, depth + 1, leftmosts))
        return result
    }
}
