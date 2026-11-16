package binarytreecameras

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    fun minCameraCover(root: TreeNode?): Int {
        if (root == null) return 0
        var result = 0
        if (dfs(root!!) { result++ } == UNCOVERED) {
            ++result
        }
        return result
    }

    private fun dfs(root: TreeNode, addCamera: () -> Unit): Int {
        val left = root.left?.let { dfs(it, addCamera) } ?: COVERED
        val right = root.right?.let { dfs(it, addCamera) } ?: COVERED
        if (left == UNCOVERED || right == UNCOVERED) {
            addCamera()
            return CAMERA
        }
        if (left == CAMERA || right == CAMERA) {
            return COVERED
        }
        return UNCOVERED
    }

    private companion object {
        const val UNCOVERED = 0
        const val COVERED = 1
        const val CAMERA = 2
    }
}
