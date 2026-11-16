package maximumsumbstinbinarytree
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    private class Result {
        var valid = false
        var sum = 0
        var min = 0
        var max = 0
    }

    private data class Frame(
        val node: TreeNode?,
        val children: Array<Result>?,
        val ret: Result
    )

    fun maxSumBST(root: TreeNode?): Int {
        var result = 0
        val ret = Result()
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(root, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            val children = frame.children
            if (children != null) {
                val left = children[0]
                val right = children[1]
                val node = frame.node!!
                if (left.valid && right.valid && left.max < node.`val` && node.`val` < right.min) {
                    val total = left.sum + node.`val` + right.sum
                    result = maxOf(result, total)
                    frame.ret.valid = true
                    frame.ret.sum = total
                    frame.ret.min = minOf(left.min, node.`val`)
                    frame.ret.max = maxOf(node.`val`, right.max)
                    continue
                }
                frame.ret.valid = false
                frame.ret.sum = 0
                frame.ret.min = 0
                frame.ret.max = 0
                continue
            }
            if (frame.node == null) {
                frame.ret.valid = true
                frame.ret.sum = 0
                frame.ret.min = Int.MAX_VALUE
                frame.ret.max = Int.MIN_VALUE
                continue
            }
            val newChildren = arrayOf(Result(), Result())
            stk.addLast(Frame(frame.node, newChildren, frame.ret))
            stk.addLast(Frame(frame.node.right, null, newChildren[1]))
            stk.addLast(Frame(frame.node.left, null, newChildren[0]))
        }
        return result
    }
}
