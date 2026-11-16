package maximumdifferencebetweennodeandancestor
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {
        var result = 0
        val stack = ArrayDeque<Triple<TreeNode?, Int, Int>>()
        stack.addLast(Triple(root, 0, Int.MAX_VALUE))
        while (stack.isNotEmpty()) {
            val (node, currentMax, currentMin) = stack.removeLast()
            if (node == null) {
                continue
            }
            var mx = currentMax
            var mn = currentMin
            result = maxOf(result, mx - node.`val`, node.`val` - mn)
            mx = maxOf(mx, node.`val`)
            mn = minOf(mn, node.`val`)
            stack.addLast(Triple(node.left, mx, mn))
            stack.addLast(Triple(node.right, mx, mn))
        }
        return result
    }
}
