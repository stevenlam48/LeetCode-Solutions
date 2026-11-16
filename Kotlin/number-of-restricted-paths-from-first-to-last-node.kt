package numberofrestrictedpathsfromfirsttolastnode

// Time:  O(|E| * log|V|)
// Space: O(|E| + |V|)

class Solution {
    fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        val adj = Array(n) { mutableListOf<IntArray>() }
        for (e in edges) {
            val u = e[0] - 1
            val v = e[1] - 1
            val w = e[2]
            adj[u].add(intArrayOf(v, w))
            adj[v].add(intArrayOf(u, w))
        }
        val dist = IntArray(n) { Int.MAX_VALUE }
        val dp = IntArray(n)
        dist[n - 1] = 0
        dp[n - 1] = 1
        val minHeap = java.util.PriorityQueue<IntArray>(
            compareBy<IntArray>({ it[0] }, { it[1] })
        )
        minHeap.add(intArrayOf(0, n - 1))
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            val w = top[0]
            val u = top[1]
            if (w > dist[u]) {
                continue
            }
            for (edge in adj[u]) {
                val v = edge[0]
                val d = edge[1]
                if (w + d < dist[v]) {
                    dist[v] = w + d
                    minHeap.add(intArrayOf(dist[v], v))
                } else if (w > dist[v]) {
                    dp[u] = (dp[u] + dp[v]) % MOD
                }
            }
            if (u == 0) {
                break
            }
        }
        return dp[0]
    }
}
