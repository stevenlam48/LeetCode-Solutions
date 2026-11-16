package allelementsintwobinarysearchtrees

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val left = Iterator(root1)
        val right = Iterator(root2)
        while (left.curr != null || right.curr != null) {
            if (right.curr == null || (left.curr != null && left.curr!!.`val` < right.curr!!.`val`)) {
                result.add(left.curr!!.`val`)
                left.inc()
            } else {
                result.add(right.curr!!.`val`)
                right.inc()
            }
        }
        return result
    }

    private class Iterator(root: TreeNode?) {
        private val stack = ArrayDeque<Pair<TreeNode?, Boolean>>()
        var curr: TreeNode? = null
            private set

        init {
            stack.addLast(root to false)
            inc()
        }

        fun inc() {
            while (stack.isNotEmpty()) {
                val (node, isVisited) = stack.removeLast()
                if (node == null) {
                    continue
                }
                if (isVisited) {
                    curr = node
                    return
                }
                stack.addLast(node.right to false)
                stack.addLast(node to true)
                stack.addLast(node.left to false)
            }
            curr = null
        }
    }
}
