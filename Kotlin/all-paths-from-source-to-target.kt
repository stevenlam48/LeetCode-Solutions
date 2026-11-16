package allpathsfromsourcetotarget

// Time:  O(p + r * n), p is the count of all the possible paths in graph,
//                      r is the count of the result.
// Space: O(n)

class Solution {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val path = mutableListOf(0)
        dfs(graph, 0, path, result)
        return result
    }

    private fun dfs(
        graph: Array<IntArray>,
        curr: Int,
        path: MutableList<Int>,
        result: MutableList<List<Int>>
    ) {
        if (curr == graph.size - 1) {
            result.add(path.toList())
            return
        }
        for (node in graph[curr]) {
            path.add(node)
            dfs(graph, node, path, result)
            path.removeAt(path.size - 1)
        }
    }
}
