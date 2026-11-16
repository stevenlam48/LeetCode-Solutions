package subtreeofanothertree

import common.TreeNode

// Time:  O(m * n), m is the number of nodes of s, n is the number of nodes of t
// Space: O(h), h is the height of s
class Solution {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        return preOrderTraverse(s, t)
    }

    private fun preOrderTraverse(s: TreeNode?, t: TreeNode?): Boolean {
        return s != null && (isSame(s, t) ||
            preOrderTraverse(s.left, t) ||
            preOrderTraverse(s.right, t))
    }

    private fun isSame(x: TreeNode?, y: TreeNode?): Boolean {
        if (x == null && y == null) {
            return true
        }
        if (x == null || y == null) {
            return false
        }
        return x.`val` == y.`val` &&
            isSame(x.left, y.left) &&
            isSame(x.right, y.right)
    }
}
