package findallthelonelynodes

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun getLonelyNodes(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        val stack = ArrayList<TreeNode?>()
        stack.add(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeAt(stack.lastIndex) ?: continue
            if (node.left != null && node.right == null) {
                result.add(node.left!!.`val`)
            } else if (node.right != null && node.left == null) {
                result.add(node.right!!.`val`)
            }
            stack.add(node.right)
            stack.add(node.left)
        }
        return result
    }
}
