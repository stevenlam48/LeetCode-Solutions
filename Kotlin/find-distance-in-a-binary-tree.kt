package finddistanceinabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun findDistance(root: TreeNode?, p: Int, q: Int): Int {
        return iterDfs(root, p, q)
    }

    private class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: IntArray?,
        val ret2: IntArray?,
        val ret: IntArray
    )

    private fun iterDfs(node: TreeNode?, p: Int, q: Int): Int {
        var result = 0
        val dist = intArrayOf(-1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, node, null, null, dist))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            val step = frame.step
            val cur = frame.node
            if (step == 1) {
                if (cur == null) {
                    continue
                }
                val ret1 = intArrayOf(-1)
                val ret2 = intArrayOf(-1)
                stk.addLast(Frame(2, cur, ret1, ret2, frame.ret))
                stk.addLast(Frame(1, cur.right, null, null, ret2))
                stk.addLast(Frame(1, cur.left, null, null, ret1))
            } else if (step == 2) {
                val ret1 = frame.ret1!!
                val ret2 = frame.ret2!!
                if (cur!!.`val` == p || cur.`val` == q) {
                    if (ret1[0] == -1 && ret2[0] == -1) {
                        frame.ret[0] = 0
                    }
                    result = if (ret1[0] != -1) ret1[0] + 1 else ret2[0] + 1
                } else if (ret1[0] != -1 && ret2[0] != -1) {
                    result = ret1[0] + ret2[0] + 2
                } else if (ret1[0] != -1) {
                    frame.ret[0] = ret1[0] + 1
                } else if (ret2[0] != -1) {
                    frame.ret[0] = ret2[0] + 1
                }
            }
        }
        return result
    }
}
