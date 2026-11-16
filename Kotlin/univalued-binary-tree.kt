package univaluedbinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun isUnivalTree(root: TreeNode?): Boolean {
        val stack = ArrayDeque<TreeNode?>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            if (node == null) {
                continue
            }
            if (node.`val` != root!!.`val`) {
                return false
            }
            stack.add(node.left)
            stack.add(node.right)
        }
        return true
    }
}
