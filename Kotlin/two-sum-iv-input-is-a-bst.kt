package twosumivinputisabst

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(h)

class Solution {
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) {
            return false
        }
        val left = BSTIterator(root, true)
        val right = BSTIterator(root, false)
        while (left.cur < right.cur) {
            val sum = left.cur + right.cur
            if (sum == k) {
                return true
            } else if (sum < k) {
                left.advance()
            } else {
                right.advance()
            }
        }
        return false
    }

    private class BSTIterator(root: TreeNode?, private val forward: Boolean) {
        private var node: TreeNode? = root
        private val s = ArrayDeque<TreeNode>()
        var cur: Int = 0

        init {
            advance()
        }

        fun advance() {
            while (node != null || s.isNotEmpty()) {
                val n = node
                if (n != null) {
                    s.addLast(n)
                    node = if (forward) n.left else n.right
                } else {
                    val top = s.removeLast()
                    cur = top.`val`
                    node = if (forward) top.right else top.left
                    break
                }
            }
        }
    }
}
