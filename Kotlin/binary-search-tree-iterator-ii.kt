package binarysearchtreeiteratorii

import common.TreeNode

// Time:  O(1), amortized
// Space: O(h)

class BSTIterator(root: TreeNode?) {
    private val stk = ArrayDeque<TreeNode>()
    private val vals = ArrayList<Int>()
    private var pos = -1

    init {
        traverseLeft(root)
    }

    fun hasNext(): Boolean {
        return pos + 1 != vals.size || stk.isNotEmpty()
    }

    fun next(): Int {
        pos += 1
        if (pos == vals.size) {
            val node = stk.removeLast()
            traverseLeft(node.right)
            vals.add(node.`val`)
        }
        return vals[pos]
    }

    fun hasPrev(): Boolean {
        return pos - 1 >= 0
    }

    fun prev(): Int {
        pos -= 1
        return vals[pos]
    }

    private fun traverseLeft(node0: TreeNode?) {
        var node = node0
        while (node != null) {
            stk.addLast(node)
            node = node.left
        }
    }
}
