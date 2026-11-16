package twosumbsts

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)

class Solution {
    fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
        val left = TreeIterator(root1, true)
        val right = TreeIterator(root2, false)
        while (left.curr != null && right.curr != null) {
            val sum = left.curr!!.`val` + right.curr!!.`val`
            if (sum < target) {
                left.advance()
            } else if (sum > target) {
                right.advance()
            } else {
                return true
            }
        }
        return false
    }

    private class TreeIterator(root: TreeNode?, private val asc: Boolean) {
        private val stack = ArrayDeque<Pair<TreeNode?, Boolean>>()
        var curr: TreeNode? = null

        init {
            stack.addLast(root to false)
            advance()
        }

        fun advance() {
            while (stack.isNotEmpty()) {
                val (node, isVisited) = stack.removeLast()
                if (node == null) {
                    continue
                }
                if (isVisited) {
                    curr = node
                    return
                }
                if (asc) {
                    stack.addLast(node.right to false)
                    stack.addLast(node to true)
                    stack.addLast(node.left to false)
                } else {
                    stack.addLast(node.left to false)
                    stack.addLast(node to true)
                    stack.addLast(node.right to false)
                }
            }
            curr = null
        }
    }
}
