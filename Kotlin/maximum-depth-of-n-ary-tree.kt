package maximumdepthofnarytree

// Time:  O(n)
// Space: O(h)

class Node(var `val`: Int, var children: List<Node?> = emptyList())

class Solution {
    fun maxDepth(root: Node?): Int {
        root ?: return 0
        var depth = 0
        for (child in root.children) {
            depth = maxOf(depth, maxDepth(child))
        }
        return 1 + depth
    }
}
