package findbottomlefttreevalue

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun findBottomLeftValue(root: TreeNode?): Int {
        val result = IntArray(1)
        val maxDepth = IntArray(1)
        findBottomLeftValueHelper(root, 0, maxDepth, result)
        return result[0]
    }

    private fun findBottomLeftValueHelper(
        root: TreeNode?,
        currentDepth: Int,
        maxDepth: IntArray,
        bottomLeftValue: IntArray
    ) {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null && currentDepth + 1 > maxDepth[0]) {
            maxDepth[0] = currentDepth + 1
            bottomLeftValue[0] = root.`val`
            return
        }
        findBottomLeftValueHelper(root.left, currentDepth + 1, maxDepth, bottomLeftValue)
        findBottomLeftValueHelper(root.right, currentDepth + 1, maxDepth, bottomLeftValue)
    }
}
