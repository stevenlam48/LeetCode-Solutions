package lowestcommonancestorofabinarytreeii

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return iterDfs(root, p, q)
    }

    private fun iterDfs(node: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var result: TreeNode? = null
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, node, null, null, IntBox()))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            val current = frame.node
            if (frame.step == 1) {
                if (current == null) {
                    continue
                }
                val ret1 = IntBox()
                val ret2 = IntBox()
                stack.addLast(Frame(2, current, ret1, ret2, frame.ret))
                stack.addLast(Frame(1, current.right, null, null, ret2))
                stack.addLast(Frame(1, current.left, null, null, ret1))
            } else {
                val curr = if (current === p || current === q) 1 else 0
                val count = curr + frame.ret1!!.value + frame.ret2!!.value
                if (count == 2 && result == null) {
                    result = current
                }
                frame.ret.value = count
            }
        }
        return result
    }

    private data class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: IntBox?,
        val ret2: IntBox?,
        val ret: IntBox
    )

    private class IntBox(var value: Int = 0)
}
