package findeventualsafestates

// Time:  O(|V| + |E|)
// Space: O(|V|)

class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val lookup = IntArray(graph.size)

        fun dfs(node: Int): Boolean {
            if (lookup[node] != 0) {
                return lookup[node] == 2
            }
            lookup[node] = 1
            for (child in graph[node]) {
                if (!dfs(child)) {
                    return false
                }
            }
            lookup[node] = 2
            return true
        }

        val result = mutableListOf<Int>()
        for (i in graph.indices) {
            if (dfs(i)) {
                result.add(i)
            }
        }
        return result
    }
}
