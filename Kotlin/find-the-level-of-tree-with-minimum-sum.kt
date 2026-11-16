package findtheleveloftreewithminimumsum
// Time:  O(n)
// Space: O(w)

import common.TreeNode

class Solution {
    fun minimumLevel(root: TreeNode?): Int {
        var q = ArrayDeque<TreeNode>()
        if (root != null) {
            q.add(root)
        }
        var minimumSum = Long.MAX_VALUE
        var minimumDepth = Long.MAX_VALUE
        var depth = 1L
        while (q.isNotEmpty()) {
            val next = ArrayDeque<TreeNode>()
            var total = 0L
            for (node in q) {
                node.left?.let(next::add)
                node.right?.let(next::add)
                total += node.`val`
            }
            if (total < minimumSum || total == minimumSum && depth < minimumDepth) {
                minimumSum = total
                minimumDepth = depth
            }
            q = next
            ++depth
        }
        return minimumDepth.toInt()
    }
}
