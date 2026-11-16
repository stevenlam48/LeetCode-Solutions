package clonenarytree

// Time:  O(n)
// Space: O(h)

class Node(var `val`: Int) {
    var children: MutableList<Node?> = mutableListOf()
}

class Solution {
    fun cloneTree(root: Node?): Node? {
        val result = Box()
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, root, null, result))
        while (stack.isNotEmpty()) {
            val (step, node, ret1, ret) = stack.removeLast()
            if (step == 1) {
                if (node == null) {
                    continue
                }
                ret.value = Node(node.`val`)
                for (i in node.children.indices.reversed()) {
                    val childResult = Box()
                    stack.addLast(Frame(2, null, childResult, ret))
                    stack.addLast(Frame(1, node.children[i], null, childResult))
                }
            } else {
                ret.value!!.children.add(ret1!!.value)
            }
        }
        return result.value
    }

    private class Box {
        var value: Node? = null
    }

    private data class Frame(
        val step: Int,
        val node: Node?,
        val ret1: Box?,
        val ret: Box
    )
}
