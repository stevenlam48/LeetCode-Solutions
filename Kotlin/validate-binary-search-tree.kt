package validatebinarysearchtree
// Time:  O(n)
// Space: O(1)

import common.TreeNode

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        var prev: TreeNode? = null
        var curr = root
        while (curr != null) {
            val left = curr.left
            if (left == null) {
                if (prev != null && prev.`val` >= curr.`val`) {
                    return false
                }
                prev = curr
                curr = curr.right
            } else {
                var node: TreeNode = left
                while (node.right != null && node.right !== curr) {
                    node = node.right!!
                }
                if (node.right == null) {
                    node.right = curr
                    curr = curr.left
                } else {
                    if (prev != null && prev.`val` >= curr.`val`) {
                        return false
                    }
                    prev = curr
                    node.right = null
                    curr = curr.right
                }
            }
        }
        return true
    }
}
