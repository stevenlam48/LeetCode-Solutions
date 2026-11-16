package kthlargestsuminabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        val arr = ArrayList<Long>()
        var q = ArrayList<TreeNode>()
        if (root != null) {
            q.add(root)
        }
        while (q.isNotEmpty()) {
            val newQ = ArrayList<TreeNode>()
            for (u in q) {
                u.left?.let { newQ.add(it) }
                u.right?.let { newQ.add(it) }
            }
            var sum = 0L
            for (node in q) {
                sum += node.`val`
            }
            arr.add(sum)
            q = newQ
        }
        if (k - 1 >= arr.size) {
            return -1
        }
        arr.sortDescending()
        return arr[k - 1]
    }
}
