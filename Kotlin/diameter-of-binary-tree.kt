package diameterofbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int = iterDfs(root)

    private class Frame(val node: TreeNode?, val ret: IntArray) {
        var left: IntArray? = null
        var right: IntArray? = null
        var visited = false
    }

    private fun iterDfs(node: TreeNode?): Int {
        var result = 0
        val stack = mutableListOf(Frame(node, IntArray(1)))
        while (stack.isNotEmpty()) {
            val frame = stack.removeAt(stack.lastIndex)
            val current = frame.node ?: continue
            if (!frame.visited) {
                frame.visited = true
                frame.left = IntArray(1)
                frame.right = IntArray(1)
                stack.add(frame)
                stack.add(Frame(current.right, frame.right!!))
                stack.add(Frame(current.left, frame.left!!))
            } else {
                result = maxOf(result, frame.left!![0] + frame.right!![0])
                frame.ret[0] = 1 + maxOf(frame.left!![0], frame.right!![0])
            }
        }
        return result
    }
}
