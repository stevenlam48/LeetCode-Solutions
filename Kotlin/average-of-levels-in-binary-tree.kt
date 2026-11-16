package averageoflevelsinbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val result = mutableListOf<Double>()
        var q = mutableListOf<TreeNode?>()
        q.add(root)
        while (q.isNotEmpty()) {
            var sum = 0L
            var count = 0L
            val nextQ = mutableListOf<TreeNode?>()
            for (n in q) {
                sum += n!!.`val`
                ++count
                if (n.left != null) {
                    nextQ.add(n.left)
                }
                if (n.right != null) {
                    nextQ.add(n.right)
                }
            }
            q = nextQ
            result.add(sum * 1.0 / count)
        }
        return result.toDoubleArray()
    }
}
