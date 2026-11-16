package binarytreeverticalordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(n)
class Solution {
    fun verticalOrder(root: TreeNode?): List<List<Int>> {
        val cols = HashMap<Int, MutableList<Int>>()
        val queue = mutableListOf<Pair<TreeNode?, Int>>()
        queue.add(Pair(root, 0))
        var i = 0
        while (i < queue.size) {
            val (node, j) = queue[i++]
            if (node != null) {
                cols.getOrPut(j) { mutableListOf() }.add(node.`val`)
                queue.add(Pair(node.left, j - 1))
                queue.add(Pair(node.right, j + 1))
            }
        }
        var minIdx = Int.MAX_VALUE
        var maxIdx = Int.MIN_VALUE
        for ((index) in cols) {
            minIdx = minOf(minIdx, index)
            maxIdx = maxOf(maxIdx, index)
        }
        val result = mutableListOf<List<Int>>()
        var index = minIdx
        while (cols.isNotEmpty() && index <= maxIdx) {
            result.add(cols.getValue(index))
            ++index
        }
        return result
    }
}
