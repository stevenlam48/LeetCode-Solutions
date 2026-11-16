package findrootofnarytree

// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int) {
    var children: MutableList<Node> = mutableListOf()
}

class Solution {
    fun findRoot(tree: List<Node>): Node? {
        val children = java.util.Collections.newSetFromMap(java.util.IdentityHashMap<Node, Boolean>())
        for (node in tree) {
            for (child in node.children) {
                children.add(child)
            }
        }
        for (node in tree) {
            if (!children.contains(node)) {
                return node
            }
        }
        return null
    }
}
