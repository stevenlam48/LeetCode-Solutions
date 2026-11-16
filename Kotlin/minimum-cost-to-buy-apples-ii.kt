package minimumcosttobuyapplesii

// Time:  O(n * (n + elogn))
// Space: O(n + e)

class Solution {
    fun minCost(n: Int, prices: IntArray, roads: Array<IntArray>): IntArray {
        val INF = Long.MAX_VALUE
        val adj = Array(2 * n) { mutableListOf<Pair<Int, Long>>() }

        fun dijkstra(start: Int, target: Int): Long {
            val best = LongArray(2 * n) { INF }
            best[start] = 0
            val minHeap = java.util.PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))
            minHeap.add(Pair(0L, start))
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.poll()
                if (curr != best[u]) {
                    continue
                }
                if (u == target) {
                    return curr
                }
                for ((v, w) in adj[u]) {
                    if (best[v] - curr <= w) {
                        continue
                    }
                    best[v] = curr + w
                    minHeap.add(Pair(best[v], v))
                }
            }
            return INF
        }

        for (r in roads) {
            val u = r[0]
            val v = r[1]
            val c = r[2].toLong()
            val t = r[3].toLong()
            adj[u].add(Pair(v, c))
            adj[v].add(Pair(u, c))
            adj[u + n].add(Pair(v + n, c * t))
            adj[v + n].add(Pair(u + n, c * t))
        }
        for (i in 0 until n) {
            adj[i].add(Pair(i + n, prices[i].toLong()))
        }
        val result = IntArray(n)
        for (i in 0 until n) {
            result[i] = dijkstra(i, i + n).toInt()
        }
        return result
    }
}
