package binarytreemaximumpathsum

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(h)
class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        return iterDfs(root)
    }

    private fun iterDfs(node: TreeNode?): Int {
        var result = Int.MIN_VALUE
        val stack = ArrayDeque<() -> Unit>()
        lateinit var divide: (TreeNode?, IntArray) -> Unit
        val conquer = { current: TreeNode, ret1: IntArray, ret2: IntArray, ret: IntArray ->
            result = maxOf(result, current.`val` + maxOf(ret1[0], 0) + maxOf(ret2[0], 0))
            ret[0] = current.`val` + maxOf(ret1[0], ret2[0], 0)
        }
        divide = { current, ret ->
            if (current != null) {
                val ret1 = intArrayOf(0)
                val ret2 = intArrayOf(0)
                stack.addLast { conquer(current, ret1, ret2, ret) }
                stack.addLast { divide(current.right, ret2) }
                stack.addLast { divide(current.left, ret1) }
            }
        }
        val maxSum = intArrayOf(0)
        stack.addLast { divide(node, maxSum) }
        while (stack.isNotEmpty()) {
            stack.removeLast().invoke()
        }
        return result
    }
}
