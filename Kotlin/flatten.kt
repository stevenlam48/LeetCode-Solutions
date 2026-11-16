package flatten

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(logn)

class Solution {
    private var p: TreeNode? = null

    fun flatten(root: TreeNode?) {
        if (root == null) {
            return
        }
        p = root
        flatten(root.left)
        p!!.right = root.right
        flatten(root.right)
        val left = root.left
        if (left != null) {
            root.right = left
            root.left = null
        }
    }
}
