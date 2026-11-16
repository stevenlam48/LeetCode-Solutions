package symmetrictree
// Time:  O(n)
// Space: O(h), h is the height of the binary tree.

import common.TreeNode

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        val nodes = ArrayDeque<TreeNode?>()
        nodes.addLast(root.left)
        nodes.addLast(root.right)
        while (nodes.isNotEmpty()) {
            val right = nodes.removeLast()
            val left = nodes.removeLast()
            if (left == null && right == null) {
                continue
            }
            if (left == null || right == null || left.`val` != right.`val`) {
                return false
            }
            nodes.addLast(left.right)
            nodes.addLast(right.left)
            nodes.addLast(left.left)
            nodes.addLast(right.right)
        }
        return true
    }
}
