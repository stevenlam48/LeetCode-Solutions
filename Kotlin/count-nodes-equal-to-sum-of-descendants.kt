package countnodesequaltosumofdescendants

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun equalToDescendants(root: TreeNode?): Int {
        var result = 0
        val total = LongArray(1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, root, null, null, total))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                val node = f.node ?: continue
                val ret1 = LongArray(1)
                val ret2 = LongArray(1)
                stk.addLast(Frame(2, node, ret1, ret2, f.ret))
                stk.addLast(Frame(1, node.right, null, null, ret2))
                stk.addLast(Frame(1, node.left, null, null, ret1))
            } else {
                val node = f.node!!
                val r1 = f.ret1!!
                val r2 = f.ret2!!
                if (node.`val`.toLong() == r1[0] + r2[0]) {
                    ++result
                }
                f.ret[0] = r1[0] + r2[0] + node.`val`
            }
        }
        return result
    }

    private data class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: LongArray?,
        val ret2: LongArray?,
        val ret: LongArray
    )
}
