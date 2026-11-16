package countdominantnodesinabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

// iterative dfs
class Solution {
    fun countDominantNodes(root: TreeNode?): Int {
        data class Ret(var cnt: Int = 0, var mx: Int = 0)
        data class Frame(val step: Int, val u: TreeNode?, val ret1: Ret?, val ret2: Ret?, val ret: Ret?)

        val result = Ret()
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, result))
        while (stk.isNotEmpty()) {
            val (step, u, ret1, ret2, ret) = stk.removeLast()
            if (step == 1) {
                if (u == null) {
                    continue
                }
                val r1 = Ret()
                val r2 = Ret()
                stk.addLast(Frame(2, u, r1, r2, ret))
                stk.addLast(Frame(1, u.right, null, null, r2))
                stk.addLast(Frame(1, u.left, null, null, r1))
            } else if (step == 2) {
                val r1 = ret1!!
                val r2 = ret2!!
                val node = u!!
                val mx = maxOf(r1.mx, r2.mx, node.`val`)
                val out = ret!!
                out.cnt = r1.cnt + r2.cnt + if (mx == node.`val`) 1 else 0
                out.mx = mx
            }
        }
        return result.cnt
    }
}
