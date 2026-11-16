package cousinsinbinarytreeii

// Time:  O(n)
// Space: O(w)

import common.TreeNode

class Solution {
    fun replaceValueInTree(root: TreeNode): TreeNode {
        var q = mutableListOf(root to root.`val`)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Pair<TreeNode, Int>>()
            val total = q.sumOf { it.first.`val` }
            for (entry in q) {
                val node = entry.first
                node.`val` = total - entry.second
                val siblingSum = (node.left?.`val` ?: 0) + (node.right?.`val` ?: 0)
                node.left?.let { newQ.add(it to siblingSum) }
                node.right?.let { newQ.add(it to siblingSum) }
            }
            q = newQ
        }
        return root
    }
}
