package cloneGraph

import java.util.ArrayDeque

// Time Complexity: O(n)
// Space Complexity: O(n)
class UndirectedGraphNode(var label: Int) {
    var neighbors: MutableList<UndirectedGraphNode> = mutableListOf()
}

class Solution {
    fun cloneGraph(node: UndirectedGraphNode?): UndirectedGraphNode? {
        if (node == null) {
            return null
        }
        val copied = HashMap<UndirectedGraphNode, UndirectedGraphNode>()
        copied[node] = UndirectedGraphNode(node.label)
        val queue = ArrayDeque<UndirectedGraphNode>()
        queue.add(node)
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            for (neighbor in current.neighbors) {
                if (!copied.containsKey(neighbor)) {
                    copied[neighbor] = UndirectedGraphNode(neighbor.label)
                    queue.add(neighbor)
                }
                copied[current]!!.neighbors.add(copied[neighbor]!!)
            }
        }
        return copied[node]
    }
}
