package binarysearchtreeiterator

import common.TreeNode

// Time:  O(1), amortized
// Space: O(h)

class BSTIterator(root: TreeNode?) {
    private val stk = ArrayDeque<TreeNode>()

    init {
        traverseLeft(root)
    }

    fun hasNext(): Boolean {
        return stk.isNotEmpty()
    }

    fun next(): Int {
        val node = stk.removeLast()
        traverseLeft(node.right)
        return node.`val`
    }

    private fun traverseLeft(node0: TreeNode?) {
        var node = node0
        while (node != null) {
            stk.addLast(node)
            node = node.left
        }
    }
}
