package narytreepreordertraversal

// Time:  O(n)
// Space: O(h)

class Node() {
    var `val`: Int = 0
    var children: MutableList<Node> = mutableListOf()

    constructor(`val`: Int) : this() {
        this.`val` = `val`
    }

    constructor(`val`: Int, children: MutableList<Node>) : this() {
        this.`val` = `val`
        this.children = children
    }
}

class Solution {
    fun preorder(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<Node>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            result.add(node.`val`)
            for (i in node.children.indices.reversed()) {
                stack.addLast(node.children[i])
            }
        }
        return result
    }
}
