package graphvalidtree

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

import java.util.ArrayDeque

class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        if (edges.size != n - 1) {
            return false
        }
        val neighbors = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            neighbors.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            neighbors.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }
        val queue = ArrayDeque<Int>()
        queue.add(0)
        val visited = hashSetOf(0)
        while (queue.isNotEmpty()) {
            val i = queue.removeFirst()
            for (node in neighbors[i].orEmpty()) {
                if (visited.add(node)) {
                    queue.add(node)
                }
            }
        }
        return visited.size == n
    }
}
