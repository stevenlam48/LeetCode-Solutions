package minimizethemaximumedgeweightofgraph
// Time:  O(nlogn + e)
// Space: O(n + e)

import java.util.PriorityQueue

class Solution {
    fun minMaxWeight(n: Int, edges: Array<IntArray>, threshold: Int): Int {
        val inf = Int.MAX_VALUE
        val adj = Array(n) { HashMap<Int, Int>() }
        for (e in edges) {
            val previous = adj[e[1]][e[0]]
            adj[e[1]][e[0]] = if (previous != null) minOf(previous, e[2]) else e[2]
        }

        val best = IntArray(n) { inf }
        best[0] = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>>({ it.first }, { it.second })
        )
        minHeap.offer(Pair(0, 0))
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.poll()
            if (curr != best[u]) {
                continue
            }
            for ((v, w) in adj[u]) {
                val candidate = maxOf(w, curr)
                if (candidate >= best[v]) {
                    continue
                }
                best[v] = candidate
                minHeap.offer(Pair(best[v], v))
            }
        }
        val result = best.max()
        return if (result != inf) result else -1
    }
}
