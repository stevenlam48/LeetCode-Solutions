package minDepth

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val q = ArrayDeque<TreeNode>()
        var d = 1
        q.addLast(root)
        var cnt = q.size
        while (q.isNotEmpty()) {
            val n = q.removeFirst()
            if (n.left == null && n.right == null) {
                return d
            }
            if (n.left != null) {
                q.addLast(n.left!!)
            }
            if (n.right != null) {
                q.addLast(n.right!!)
            }
            cnt--
            if (cnt == 0) {
                cnt = q.size
                d++
            }
        }
        return d
    }
}
