package evaluatebooleanbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)
class Solution {
    private class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: IntArray?,
        val ret2: IntArray?,
        val ret: IntArray
    )

    fun evaluateTree(root: TreeNode?): Boolean {
        val stk = ArrayDeque<Frame>()
        val ret = IntArray(1)
        stk.addLast(Frame(1, root, null, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            if (frame.step == 1) {
                val node = frame.node!!
                if (node.left == node.right) {
                    frame.ret[0] = node.`val`
                    continue
                }
                val ret1 = IntArray(1)
                val ret2 = IntArray(1)
                stk.addLast(Frame(2, node, ret1, ret2, frame.ret))
                stk.addLast(Frame(1, node.right, null, null, ret2))
                stk.addLast(Frame(1, node.left, null, null, ret1))
            } else {
                val node = frame.node!!
                val ret1 = frame.ret1!!
                val ret2 = frame.ret2!!
                frame.ret[0] = if (node.`val` == 2) {
                    ret1[0] or ret2[0]
                } else {
                    ret1[0] and ret2[0]
                }
            }
        }
        return ret[0] != 0
    }
}
