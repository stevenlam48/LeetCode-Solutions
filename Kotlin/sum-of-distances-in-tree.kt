package sumofdistancesintree

// Time:  O(n)
// Space: O(n)
class Solution {
    fun sumOfDistancesInTree(N: Int, edges: Array<IntArray>): IntArray {
        val graph = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            graph.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            graph.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        val count = IntArray(N) { 1 }
        val result = IntArray(N)

        dfs(graph, 0, -1, count, result)
        dfs2(graph, 0, -1, count, result)
        return result
    }

    private fun dfs(
        graph: HashMap<Int, MutableList<Int>>,
        node: Int,
        parent: Int,
        count: IntArray,
        result: IntArray
    ) {
        val neighbors = graph[node] ?: return
        for (nei in neighbors) {
            if (nei != parent) {
                dfs(graph, nei, node, count, result)
                count[node] += count[nei]
                result[node] += result[nei] + count[nei]
            }
        }
    }

    private fun dfs2(
        graph: HashMap<Int, MutableList<Int>>,
        node: Int,
        parent: Int,
        count: IntArray,
        result: IntArray
    ) {
        val neighbors = graph[node] ?: return
        for (nei in neighbors) {
            if (nei != parent) {
                result[nei] = result[node] - count[nei] + count.size - count[nei]
                dfs2(graph, nei, node, count, result)
            }
        }
    }
}
