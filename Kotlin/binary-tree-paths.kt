package binarytreepaths

import common.TreeNode

// Time:  O(n * h)
// Space: O(h)
class Solution {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        val path = mutableListOf<TreeNode>()
        binaryTreePathsRecu(root, path, result)
        return result
    }

    private fun binaryTreePathsRecu(node: TreeNode?, path: MutableList<TreeNode>, result: MutableList<String>) {
        if (node == null) return
        if (node.left == null && node.right == null) {
            result.add(path.joinToString("") { "${it.`val`}->" } + node.`val`)
        }
        node.left?.let {
            path.add(node)
            binaryTreePathsRecu(it, path, result)
            path.removeAt(path.lastIndex)
        }
        node.right?.let {
            path.add(node)
            binaryTreePathsRecu(it, path, result)
            path.removeAt(path.lastIndex)
        }
    }
}
