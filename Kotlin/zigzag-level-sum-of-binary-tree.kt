package zigzaglevelsumofbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(w)

// bfs
class Solution {
    fun zigzagLevelSum(root: TreeNode?): List<Long> {
        val result = ArrayList<Long>()
        if (root == null) {
            return result
        }
        var q = listOf(root)
        var parity = 0
        while (q.isNotEmpty()) {
            val newQ = ArrayList<TreeNode>()
            var total = 0L
            var stop = false
            for (i in q.indices.reversed()) {
                val node = q[i]
                val left = if (parity == 0) node.left else node.right
                val right = if (parity == 0) node.right else node.left
                if (left != null) {
                    newQ.add(left)
                }
                if (right != null) {
                    newQ.add(right)
                }
                stop = stop || left == null
                if (!stop) {
                    total += node.`val`
                }
            }
            result.add(total)
            q = newQ
            parity = parity xor 1
        }
        return result
    }
}
