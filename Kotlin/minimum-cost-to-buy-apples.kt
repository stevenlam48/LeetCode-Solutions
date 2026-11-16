package minimumcosttobuyapples

// Time:  O(n * rlogn), r = len(roads)
// Space: O(n)

class Solution {
    fun minCost(n: Int, roads: Array<IntArray>, appleCost: IntArray, k: Int): LongArray {
        val INF = Int.MAX_VALUE
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (r in roads) {
            adj[r[0] - 1].add(Pair(r[1] - 1, r[2]))
            adj[r[1] - 1].add(Pair(r[0] - 1, r[2]))
        }

        fun dijkstra(start: Int): LongArray {
            val best = LongArray(n) { INF.toLong() }
            best[start] = 0
            val minHeap = java.util.PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))
            minHeap.add(Pair(0L, start))
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.poll()
                if (best[u] < curr) {
                    continue
                }
                for ((v, w) in adj[u]) {
                    if (best[v] - curr <= w) {
                        continue
                    }
                    best[v] = curr + w
                    minHeap.add(Pair(curr + w, v))
                }
            }
            return best
        }

        val result = LongArray(n) { INF.toLong() }
        for (u in 0 until n) {
            val best = dijkstra(u)
            for (v in 0 until n) {
                result[u] = minOf(result[u], appleCost[v] + (k + 1).toLong() * best[v])
            }
        }
        return result
    }
}
