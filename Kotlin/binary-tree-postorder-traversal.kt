package binarytreepostordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val dummy = TreeNode(Int.MIN_VALUE)
        dummy.left = root
        var cur: TreeNode? = dummy
        while (cur != null) {
            val left = cur.left
            if (left == null) {
                cur = cur.right
            } else {
                var node: TreeNode = left
                while (node.right != null && node.right !== cur) {
                    node = node.right!!
                }
                if (node.right == null) {
                    node.right = cur
                    cur = left
                } else {
                    result.addAll(traceBack(left, node))
                    node.right = null
                    cur = cur.right
                }
            }
        }
        return result
    }

    private fun traceBack(from: TreeNode, to: TreeNode): List<Int> {
        val result = mutableListOf<Int>()
        var cur: TreeNode? = from
        while (cur !== to) {
            result.add(cur!!.`val`)
            cur = cur.right
        }
        result.add(to.`val`)
        result.reverse()
        return result
    }
}
