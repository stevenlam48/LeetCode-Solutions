package clonebinarytreewithrandompointer

// Time:  O(n)
// Space: O(h)

open class Node(var `val`: Int = 0) {
    var left: Node? = null
    var right: Node? = null
    var random: Node? = null
}

class NodeCopy(`val`: Int = 0) : Node(`val`)

class Solution {
    fun copyRandomBinaryTree(root: Node?): NodeCopy? {
        val merge = { node: Node ->
            val copy = NodeCopy(node.`val`)
            val left = node.left
            node.left = copy
            copy.left = left
            Pair(left, copy)
        }
        val clone = { node: Node ->
            val copy = node.left as NodeCopy
            copy.random = node.random?.left
            copy.right = node.right?.left
            Pair(copy.left, copy)
        }
        val split = { node: Node ->
            val copy = node.left as NodeCopy
            val left = copy.left
            node.left = left
            copy.left = left?.left
            Pair(node.left, copy)
        }
        iterDfs(root, merge)
        iterDfs(root, clone)
        return iterDfs(root, split)
    }

    private fun iterDfs(root: Node?, callback: (Node) -> Pair<Node?, NodeCopy>): NodeCopy? {
        var result: NodeCopy? = null
        val stack = ArrayDeque<Node?>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast() ?: continue
            val (left, copy) = callback(node)
            if (result == null) {
                result = copy
            }
            stack.addLast(node.right)
            stack.addLast(left)
        }
        return result
    }
}
