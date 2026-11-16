package numberofwaystoarriveatdestination

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|),
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

class Solution {
    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (road in roads) {
            adj[road[0]].add(road[1] to road[2])
            adj[road[1]].add(road[0] to road[2])
        }
        return dijkstra(adj, 0, n - 1)
    }

    private fun dijkstra(adj: Array<MutableList<Pair<Int, Int>>>, start: Int, target: Int): Int {
        val MOD = 1_000_000_007

        val best = HashMap<Int, Long>()
        best[start] = 0L
        val minHeap = java.util.PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
        minHeap.add(0L to start)
        val dp = IntArray(adj.size)
        dp[0] = 1
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.poll()
            if (best[u]!! < curr) {
                continue
            }
            if (u == target) {
                break
            }
            for ((v, w) in adj[u]) {
                if (best.containsKey(v) && best[v]!! - curr <= w) {
                    if (best[v]!! - curr == w.toLong()) {
                        dp[v] = ((dp[v].toLong() + dp[u]) % MOD).toInt()
                    }
                    continue
                }
                dp[v] = dp[u]
                best[v] = curr + w
                minHeap.add(curr + w to v)
            }
        }
        return dp[target]
    }
}
