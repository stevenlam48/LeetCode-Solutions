package amountoftimeforbinarytreetobeinfected

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(h)

// iterative dfs, tree dp
class Solution {
    private class Ret(var first: Int = -1, var second: Int = -1)

    private class Frame(
        val step: Int,
        val curr: TreeNode?,
        val left: Ret?,
        val right: Ret?,
        val ret: Ret?
    )

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        var result = -1
        val ret = Ret(-1, -1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            val step = frame.step
            val curr = frame.curr
            if (step == 1) {
                if (curr == null) {
                    continue
                }
                val left = Ret(-1, -1)
                val right = Ret(-1, -1)
                stk.addLast(Frame(2, curr, left, right, frame.ret))
                stk.addLast(Frame(1, curr.right, null, null, right))
                stk.addLast(Frame(1, curr.left, null, null, left))
            } else if (step == 2) {
                val left = frame.left!!
                val right = frame.right!!
                var d = -1
                if (curr!!.`val` == start) {
                    d = 0
                    result = maxOf(left.first, right.first) + 1
                } else if (left.second >= 0) {
                    d = left.second + 1
                    result = maxOf(result, right.first + 1 + d)
                } else if (right.second >= 0) {
                    d = right.second + 1
                    result = maxOf(result, left.first + 1 + d)
                }
                frame.ret!!.first = maxOf(left.first, right.first) + 1
                frame.ret.second = d
            }
        }
        return result
    }
}
