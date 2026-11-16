package binarytreepreordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        var curr = root
        while (curr != null) {
            val left = curr.left
            if (left == null) {
                result.add(curr.`val`)
                curr = curr.right
            } else {
                var node: TreeNode = left
                while (node.right != null && node.right !== curr) {
                    node = node.right!!
                }
                if (node.right == null) {
                    result.add(curr.`val`)
                    node.right = curr
                    curr = left
                } else {
                    node.right = null
                    curr = curr.right
                }
            }
        }
        return result
    }
}
