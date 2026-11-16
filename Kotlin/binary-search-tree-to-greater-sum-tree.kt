package binarysearchtreetogreatersumtree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun bstToGst(root: TreeNode?): TreeNode? {
        val prev = intArrayOf(0)
        return bstToGstHelper(root, prev)
    }

    private fun bstToGstHelper(root: TreeNode?, prev: IntArray): TreeNode? {
        if (root == null) {
            return root
        }
        bstToGstHelper(root.right, prev)
        root.`val` += prev[0]
        prev[0] = root.`val`
        bstToGstHelper(root.left, prev)
        return root
    }
}
