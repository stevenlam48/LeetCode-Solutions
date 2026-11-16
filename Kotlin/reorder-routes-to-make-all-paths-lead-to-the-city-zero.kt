package reorderroutestomakeallpathsleadtothecityzero
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val lookup = HashSet<Long>()
        val graph = HashMap<Int, MutableList<Int>>()
        for (connection in connections) {
            lookup.add(connection[0].toLong() * n + connection[1])
            graph.getOrPut(connection[0]) { mutableListOf() }.add(connection[1])
            graph.getOrPut(connection[1]) { mutableListOf() }.add(connection[0])
        }
        var result = 0
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(-1 to 0)
        while (stack.isNotEmpty()) {
            val (parent, u) = stack.removeLast()
            for (v in graph[u].orEmpty()) {
                if (v == parent) {
                    continue
                }
                stack.addLast(u to v)
            }
            if (lookup.contains(parent.toLong() * n + u)) {
                ++result
            }
        }
        return result
    }
}
