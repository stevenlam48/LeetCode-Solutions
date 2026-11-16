package binarytreepruning

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    fun pruneTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = pruneTree(root.left)
        root.right = pruneTree(root.right)
        if (root.left == null && root.right == null && root.`val` == 0) {
            return null
        }
        return root
    }
}
