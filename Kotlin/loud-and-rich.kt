package loudandrich

// Time:  O(q + r)
// Space: O(q + r)

class Solution {
    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val graph = Array(quiet.size) { mutableListOf<Int>() }
        for (r in richer) {
            graph[r[1]].add(r[0])
        }
        val result = IntArray(quiet.size) { -1 }
        for (i in quiet.indices) {
            dfs(graph, quiet, i, result)
        }
        return result
    }

    private fun dfs(
        graph: Array<MutableList<Int>>,
        quiet: IntArray,
        node: Int,
        result: IntArray
    ): Int {
        if (result[node] == -1) {
            result[node] = node
            for (nei in graph[node]) {
                val smallestPerson = dfs(graph, quiet, nei, result)
                if (quiet[smallestPerson] < quiet[result[node]]) {
                    result[node] = smallestPerson
                }
            }
        }
        return result[node]
    }
}
