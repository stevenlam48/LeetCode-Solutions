package lowestcommonancestorofabinarytreeiv

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, nodes: List<TreeNode>): TreeNode? {
        return iterDfs(root, nodes.toHashSet())
    }

    private fun iterDfs(node: TreeNode?, lookup: Set<TreeNode>): TreeNode? {
        val result = TreeBox()
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, node, null, null, result))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            val current = frame.node
            if (frame.step == 1) {
                if (current == null || lookup.contains(current)) {
                    frame.ret.value = current
                    continue
                }
                val ret1 = TreeBox()
                val ret2 = TreeBox()
                stack.addLast(Frame(2, current, ret1, ret2, frame.ret))
                stack.addLast(Frame(1, current.right, null, null, ret2))
                stack.addLast(Frame(1, current.left, null, null, ret1))
            } else {
                frame.ret.value = if (frame.ret1!!.value != null && frame.ret2!!.value != null) {
                    current
                } else if (frame.ret1!!.value != null) {
                    frame.ret1!!.value
                } else {
                    frame.ret2!!.value
                }
            }
        }
        return result.value
    }

    private data class Frame(
        val step: Int,
        val node: TreeNode?,
        val ret1: TreeBox?,
        val ret2: TreeBox?,
        val ret: TreeBox
    )

    private class TreeBox(var value: TreeNode? = null)
}
