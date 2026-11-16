package medianofabinarysearchtreelevel
// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun levelMedian(root: TreeNode, level: Int): Int {
        var q = listOf(root)
        var d = 0
        while (q.isNotEmpty()) {
            if (d == level) {
                return q[q.size / 2].`val`
            }
            val newQ = mutableListOf<TreeNode>()
            for (u in q) {
                u.left?.let(newQ::add)
                u.right?.let(newQ::add)
            }
            q = newQ
            ++d
        }
        return -1
    }
}
