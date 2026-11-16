package splitbst
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun splitBST(root: TreeNode?, V: Int): Array<TreeNode?> {
        if (root == null) {
            return arrayOf(null, null)
        } else if (root.`val` <= V) {
            val result = splitBST(root.right, V)
            root.right = result[0]
            return arrayOf(root, result[1])
        } else {
            val result = splitBST(root.left, V)
            root.left = result[1]
            return arrayOf(result[0], root)
        }
    }
}
