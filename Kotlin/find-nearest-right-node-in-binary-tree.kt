package findnearestrightnodeinbinarytree

// Time:  O(n)
// Space: O(w)

import common.TreeNode

class Solution {
    fun findNeartestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        var q = listOf(root)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<TreeNode?>()
            for (i in q.indices) {
                if (q[i] === u) {
                    return if (i + 1 < q.size) q[i + 1] else null
                }
                if (q[i]?.left != null) {
                    newQ.add(q[i]!!.left)
                }
                if (q[i]?.right != null) {
                    newQ.add(q[i]!!.right)
                }
            }
            q = newQ
        }
        return null
    }
}
