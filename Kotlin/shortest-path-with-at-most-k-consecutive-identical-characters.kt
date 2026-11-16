package shortestpathwithatmostkconsecutiveidenticalcharacters

// Time:  O(e * k * log(n * k))
// Space: O(n * k + e)

import java.util.PriorityQueue

class Solution {
    private data class State(val d: Int, val u: Int, val c: Int)

    fun shortestPath(n: Int, edges: Array<IntArray>, labels: String, k: Int): Int {
        val inf = Int.MAX_VALUE
        val adj = Array(n) { ArrayList<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(e[1] to e[2])
        }
        val dist = Array(n) { IntArray(k) { inf } }
        dist[0][0] = 0
        val minHeap = PriorityQueue(compareBy<State> { it.d }.thenBy { it.u }.thenBy { it.c })
        minHeap.add(State(dist[0][0], 0, 0))
        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val d = cur.d
            val u = cur.u
            val c = cur.c
            if (d > dist[u][c]) {
                continue
            }
            if (u == n - 1) {
                return d
            }
            for ((v, w) in adj[u]) {
                val nc = if (labels[v] == labels[u]) c + 1 else 0
                if (!(nc < k && d + w < dist[v][nc])) {
                    continue
                }
                dist[v][nc] = d + w
                minHeap.add(State(dist[v][nc], v, nc))
            }
        }
        return -1
    }
}
