package maximumsubgraphscoreinatree
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSubgraphScore(n: Int, edges: Array<IntArray>, good: IntArray): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val parent = IntArray(n) { -1 }
        val q = mutableListOf(0)
        for (i in 0 until n) {
            val u = q[i]
            for (v in adj[u]) {
                if (v == parent[u]) {
                    continue
                }
                parent[v] = u
                q.add(v)
            }
        }
        val dp = IntArray(n) { i -> if (good[i] != 0) 1 else -1 }
        for (i in n - 1 downTo 0) {
            if (parent[q[i]] == -1) {
                continue
            }
            dp[parent[q[i]]] += maxOf(dp[q[i]], 0)
        }
        for (i in 0 until n) {
            if (parent[q[i]] == -1) {
                continue
            }
            dp[q[i]] += maxOf(dp[parent[q[i]]] - maxOf(dp[q[i]], 0), 0)
        }
        return dp
    }
}
