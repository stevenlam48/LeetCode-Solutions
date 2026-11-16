package largestbstsubtree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun largestBSTSubtree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val maxSize = intArrayOf(1)
        largestBSTSubtreeHelper(root, maxSize)
        return maxSize[0]
    }

    private fun largestBSTSubtreeHelper(root: TreeNode, maxSize: IntArray): Triple<Int, Int, Int> {
        if (root.left == null && root.right == null) {
            return Triple(1, root.`val`, root.`val`)
        }
        var leftSize = 0
        var leftMin = root.`val`
        var leftMax = root.`val`
        root.left?.let {
            val left = largestBSTSubtreeHelper(it, maxSize)
            leftSize = left.first
            leftMin = left.second
            leftMax = left.third
        }
        var rightSize = 0
        var rightMin = root.`val`
        var rightMax = root.`val`
        root.right?.let {
            val right = largestBSTSubtreeHelper(it, maxSize)
            rightSize = right.first
            rightMin = right.second
            rightMax = right.third
        }
        var size = 0
        if ((root.left == null || leftSize > 0) &&
            (root.right == null || rightSize > 0) &&
            leftMax <= root.`val` && root.`val` <= rightMin
        ) {
            size = 1 + leftSize + rightSize
            maxSize[0] = maxOf(maxSize[0], size)
        }
        return Triple(size, leftMin, rightMax)
    }
}
