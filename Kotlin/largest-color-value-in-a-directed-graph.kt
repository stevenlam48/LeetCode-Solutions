package largestcolorvalueinadirectedgraph

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val adj = Array(colors.length) { mutableListOf<Int>() }
        val inDegree = IntArray(colors.length)
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            ++inDegree[edge[1]]
        }
        var q = mutableListOf<Int>()
        for (i in colors.indices) {
            if (inDegree[i] == 0) {
                q.add(i)
            }
        }
        val dp = Array(colors.length) { IntArray(26) }
        var result = -1
        var cnt = 0
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                ++cnt
                result = maxOf(result, ++dp[u][colors[u] - 'a'])
                for (v in adj[u]) {
                    for (c in 0 until 26) {
                        dp[v][c] = maxOf(dp[v][c], dp[u][c])
                    }
                    if (--inDegree[v] == 0) {
                        newQ.add(v)
                    }
                }
            }
            q = newQ
        }
        return if (cnt == colors.length) result else -1
    }
}
