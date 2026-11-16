package closestbinarysearchtreevalueii

import common.TreeNode
import kotlin.math.abs

// Time:  O(h + k)
// Space: O(h)
class Solution {
    fun closestKValues(root: TreeNode?, target: Double, k: Int): IntArray {
        val backward = { stack: MutableList<TreeNode> -> stack.last().left }
        val forward = { stack: MutableList<TreeNode> -> stack.last().right }
        val closest = { a: TreeNode, b: TreeNode ->
            abs(a.`val` - target) < abs(b.`val` - target)
        }

        val stack = mutableListOf<TreeNode>()
        var current = root
        while (current != null) {
            val node = current
            stack.add(node)
            current = if (target < node.`val`) node.left else node.right
        }

        var closestIndex = 0
        for (i in 1 until stack.size) {
            if (closest(stack[i], stack[closestIndex])) {
                closestIndex = i
            }
        }
        val forwardStack = stack.subList(0, closestIndex + 1).toMutableList()
        val backwardStack = forwardStack.toMutableList()
        nextNode(backwardStack, backward, forward)

        val result = mutableListOf<Int>()
        for (i in 0 until k) {
            if (forwardStack.isNotEmpty() &&
                (backwardStack.isEmpty() || closest(forwardStack.last(), backwardStack.last()))
            ) {
                result.add(forwardStack.last().`val`)
                nextNode(forwardStack, forward, backward)
            } else if (backwardStack.isNotEmpty() &&
                (forwardStack.isEmpty() || !closest(forwardStack.last(), backwardStack.last()))
            ) {
                result.add(backwardStack.last().`val`)
                nextNode(backwardStack, backward, forward)
            }
        }
        return result.toIntArray()
    }

    private fun nextNode(
        stack: MutableList<TreeNode>,
        child1: (MutableList<TreeNode>) -> TreeNode?,
        child2: (MutableList<TreeNode>) -> TreeNode?,
    ) {
        if (stack.isNotEmpty()) {
            val next = child2(stack)
            if (next != null) {
                stack.add(next)
                while (true) {
                    val child = child1(stack) ?: break
                    stack.add(child)
                }
            } else {
                var child = stack.removeAt(stack.lastIndex)
                while (stack.isNotEmpty() && child === child2(stack)) {
                    child = stack.removeAt(stack.lastIndex)
                }
            }
        }
    }
}
