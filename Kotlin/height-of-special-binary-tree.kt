package heightofspecialbinarytree
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun heightOfTree(root: TreeNode?): Int {
        var result = -1
        val stk = ArrayDeque<Pair<TreeNode, Int>>()
        if (root != null) {
            stk.addLast(root to 0)
        }
        while (stk.isNotEmpty()) {
            val (u, d) = stk.removeLast()
            result = maxOf(result, d)
            val right = u.right
            if (right != null && right.left !== u) {
                stk.addLast(right to d + 1)
            }
            val left = u.left
            if (left != null && left.right !== u) {
                stk.addLast(left to d + 1)
            }
        }
        return result
    }
}
