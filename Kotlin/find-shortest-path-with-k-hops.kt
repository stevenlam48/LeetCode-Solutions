package findshortestpathwithkhops

// Time:  O(n * k + (e * k) * log(n * k))
// Space: O(n * k + e)

// dijkstra's algorithm
class Solution {
    fun shortestPathWithHops(n: Int, edges: Array<IntArray>, s: Int, d: Int, k: Int): Int {
        val adj = Array(n) { mutableListOf<IntArray>() }
        for (e in edges) {
            adj[e[0]].add(intArrayOf(e[1], e[2]))
            adj[e[1]].add(intArrayOf(e[0], e[2]))
        }

        val INF = Int.MAX_VALUE
        val best = Array(adj.size) { IntArray(k + 1) { INF } }
        best[s][0] = 0
        val minHeap = java.util.PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }, { it[2] }))
        minHeap.add(intArrayOf(best[s][0], s, 0))
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            val curr = top[0]
            val u = top[1]
            val cnt = top[2]
            if (curr > best[u][cnt]) {
                continue
            }
            if (u == d) {
                return curr
            }
            for (e in adj[u]) {
                val v = e[0]
                val w = e[1]
                if (w < best[v][cnt] - curr) {
                    best[v][cnt] = curr + w
                    minHeap.add(intArrayOf(best[v][cnt], v, cnt))
                }
                if (cnt + 1 <= k && curr < best[v][cnt + 1]) {
                    best[v][cnt + 1] = curr
                    minHeap.add(intArrayOf(best[v][cnt + 1], v, cnt + 1))
                }
            }
        }
        return -1
    }
}
