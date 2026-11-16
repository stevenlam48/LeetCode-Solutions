package convertbsttogreatertree

import common.TreeNode
// Time:  O(n)
// Space: O(h)

class Solution {
    fun convertBST(root: TreeNode?): TreeNode? {
        val curSum = IntArray(1)
        convertBSTHelper(root, curSum)
        return root
    }

    private fun convertBSTHelper(root: TreeNode?, curSum: IntArray) {
        if (root == null) {
            return
        }
        if (root.right != null) {
            convertBSTHelper(root.right, curSum)
        }
        curSum[0] += root.`val`
        root.`val` = curSum[0]
        if (root.left != null) {
            convertBSTHelper(root.left, curSum)
        }
    }
}
