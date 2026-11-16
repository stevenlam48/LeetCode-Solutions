package isgraphbipartite

// Time:  O(|V| + |E|)
// Space: O(|V|)

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val color = HashMap<Int, Int>()
        for (node in graph.indices) {
            if (color.containsKey(node)) {
                continue
            }
            val stack = mutableListOf(node)
            color[node] = 0
            while (stack.isNotEmpty()) {
                val curr = stack.removeAt(stack.size - 1)
                for (neighbor in graph[curr]) {
                    if (!color.containsKey(neighbor)) {
                        stack.add(neighbor)
                        color[neighbor] = color[curr]!! xor 1
                    } else if (color[neighbor] == color[curr]) {
                        return false
                    }
                }
            }
        }
        return true
    }
}
