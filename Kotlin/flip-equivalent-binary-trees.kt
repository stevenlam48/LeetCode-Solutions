package flipequivalentbinarytrees

// Time:  O(n)
// Space: O(h)

import common.TreeNode
import java.util.LinkedList

class Solution {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        val q1 = LinkedList<TreeNode?>()
        val q2 = LinkedList<TreeNode?>()
        q1.add(root1)
        q2.add(root2)
        while (q1.isNotEmpty() && q2.isNotEmpty()) {
            val node1 = q1.removeFirst()
            val node2 = q2.removeFirst()
            if (node1 == null && node2 == null) {
                continue
            }
            if (node1 == null || node2 == null || node1.`val` != node2.`val`) {
                return false
            }
            val left1 = node1.left
            val right1 = node1.right
            val left2 = node2.left
            val right2 = node2.right
            if ((left1 == null && right2 == null) ||
                (left1 != null && right2 != null && left1.`val` == right2.`val`)
            ) {
                q1.add(right1)
                q1.add(left1)
            } else {
                q1.add(left1)
                q1.add(right1)
            }
            q2.add(left2)
            q2.add(right2)
        }
        return q1.isEmpty() && q2.isEmpty()
    }
}
