package narytreelevelordertraversal

// Time:  O(n)
// Space: O(w)

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
    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) {
            return emptyList()
        }
        val result = mutableListOf<List<Int>>()
        var q = mutableListOf(root)
        while (q.isNotEmpty()) {
            val curr = mutableListOf<Int>()
            val nextQ = mutableListOf<Node>()
            for (node in q) {
                for (child in node.children) {
                    nextQ.add(child)
                }
                curr.add(node.`val`)
            }
            result.add(curr)
            q = nextQ
        }
        return result
    }
}
