package smalleststringstartingfromleaf
// Time:  O(n + l * h), l is the number of leaves
// Space: O(h)

import common.TreeNode

class Solution {
    fun smallestFromLeaf(root: TreeNode?): String {
        var result = "~"
        val candidate = StringBuilder()
        dfs(root, candidate) { result = minOf(result, it) }
        return result
    }

    private fun dfs(node: TreeNode?, candidate: StringBuilder, update: (String) -> Unit) {
        if (node == null) {
            return
        }
        candidate.append('a' + node.`val`)
        if (node.left == null && node.right == null) {
            update(candidate.reverse().toString())
            candidate.reverse()
        }
        dfs(node.left, candidate, update)
        dfs(node.right, candidate, update)
        candidate.deleteCharAt(candidate.lastIndex)
    }
}
