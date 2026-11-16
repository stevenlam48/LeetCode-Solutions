package rangesumofbst

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        var result = 0
        val s = ArrayDeque<TreeNode?>()
        s.addLast(root)
        while (s.isNotEmpty()) {
            val node = s.removeLast()
            if (node != null) {
                if (L <= node.`val` && node.`val` <= R) {
                    result += node.`val`
                }
                if (L <= node.`val`) {
                    s.addLast(node.left)
                }
                if (node.`val` <= R) {
                    s.addLast(node.right)
                }
            }
        }
        return result
    }
}
