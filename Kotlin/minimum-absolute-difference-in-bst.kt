package minimumabsolutedifferenceinbst

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun getMinimumDifference(root: TreeNode?): Int {
        var result = Int.MAX_VALUE
        var prev: TreeNode? = null
        fun inorder(node: TreeNode?) {
            if (node == null) {
                return
            }
            inorder(node.left)
            if (prev != null) {
                result = minOf(result, node.`val` - prev!!.`val`)
            }
            prev = node
            inorder(node.right)
        }
        inorder(root)
        return result
    }
}
