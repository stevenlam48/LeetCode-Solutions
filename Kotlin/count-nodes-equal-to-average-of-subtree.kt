package countnodesequaltoaverageofsubtree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

// dfs
class Solution {
    fun averageOfSubtree(root: TreeNode?): Int {
        var result = 0
        val ret = IntArray(2)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, ret))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                val node = f.node ?: continue
                val ret1 = IntArray(2)
                val ret2 = IntArray(2)
                stk.addLast(Frame(2, node, ret1, ret2, f.ret))
                stk.addLast(Frame(1, node.right, null, null, ret2))
                stk.addLast(Frame(1, node.left, null, null, ret1))
            } else {
                val node = f.node!!
                val r1 = f.ret1!!
                val r2 = f.ret2!!
                f.ret[0] = r1[0] + r2[0] + node.`val`
                f.ret[1] = r1[1] + r2[1] + 1
                if (f.ret[0] / f.ret[1] == node.`val`) {
                    ++result
                }
            }
        }
        return result
    }

    private data class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: IntArray?,
        val ret2: IntArray?,
        val ret: IntArray
    )
}
