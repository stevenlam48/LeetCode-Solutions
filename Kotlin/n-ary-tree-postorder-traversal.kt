package narytreepostordertraversal

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
    fun postorder(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<Node>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val node = stack.removeLast()
            result.add(node.`val`)
            for (child in node.children) {
                stack.addLast(child)
            }
        }
        result.reverse()
        return result
    }
}
