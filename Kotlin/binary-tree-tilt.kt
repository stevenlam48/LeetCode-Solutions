package binarytreetilt

import common.TreeNode
import kotlin.math.abs

// Time:  O(n)
// Space: O(n)
class Solution {
    fun findTilt(root: TreeNode?): Int {
        var tilt = 0
        postOrderTraverse(root) { tilt += it }
        return tilt
    }

    private fun postOrderTraverse(root: TreeNode?, addTilt: (Int) -> Unit): Int {
        if (root == null) return 0
        val left = postOrderTraverse(root.left, addTilt)
        val right = postOrderTraverse(root.right, addTilt)
        addTilt(abs(left - right))
        return left + right + root.`val`
    }
}
