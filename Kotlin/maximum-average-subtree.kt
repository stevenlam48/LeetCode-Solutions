package maximumaveragesubtree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun maximumAverageSubtree(root: TreeNode?): Double {
        val result = doubleArrayOf(0.0)
        maximumAverageSubtreeHelper(root, result)
        return result[0]
    }

    private fun maximumAverageSubtreeHelper(root: TreeNode?, result: DoubleArray): Pair<Double, Double> {
        if (root == null) {
            return 0.0 to 0.0
        }
        val (s1, n1) = maximumAverageSubtreeHelper(root.left, result)
        val (s2, n2) = maximumAverageSubtreeHelper(root.right, result)
        val s = s1 + s2 + root.`val`
        val n = n1 + n2 + 1
        result[0] = maxOf(result[0], s / n)
        return s to n
    }
}
