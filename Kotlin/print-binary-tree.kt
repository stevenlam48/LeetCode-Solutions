package printbinarytree

import common.TreeNode

// Time:  O(h * 2^h)
// Space: O(h * 2^h)

class Solution {
    fun printTree(root: TreeNode?): List<List<String>> {
        val h = getHeight(root)
        val w = getWidth(root)
        val result = Array(h) { Array(w) { "" } }
        preorderTraversal(root, 0, 0, w - 1, result)
        return result.map { it.toList() }
    }

    private fun getHeight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxOf(getHeight(root.left), getHeight(root.right)) + 1
    }

    private fun getWidth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 2 * maxOf(getWidth(root.left), getWidth(root.right)) + 1
    }

    private fun preorderTraversal(root: TreeNode?, level: Int, left: Int, right: Int, result: Array<Array<String>>) {
        if (root == null) {
            return
        }
        val mid = left + (right - left) / 2
        result[level][mid] = root.`val`.toString()
        preorderTraversal(root.left, level + 1, left, mid - 1, result)
        preorderTraversal(root.right, level + 1, mid + 1, right, result)
    }
}
