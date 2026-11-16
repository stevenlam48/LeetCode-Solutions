package sumofnodeswithevenvaluedgrandparent

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        return sumEvenGrandparentHelper(root, 1, 1)
    }

    private fun sumEvenGrandparentHelper(root: TreeNode?, parent: Int, grandparent: Int): Int {
        if (root == null) {
            return 0
        }
        return sumEvenGrandparentHelper(root.left, root.`val`, parent) +
            sumEvenGrandparentHelper(root.right, root.`val`, parent) +
            if (grandparent % 2 == 0) root.`val` else 0
    }
}
