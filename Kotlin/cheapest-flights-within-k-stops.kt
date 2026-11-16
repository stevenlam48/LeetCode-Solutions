package cheapestflightswithinkstops

import java.util.PriorityQueue

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (flight in flights) {
            adj.getOrPut(flight[0]) { mutableListOf() }.add(Pair(flight[1], flight[2]))
        }
        val best = HashMap<Int, HashMap<Int, Int>>()
        best.getOrPut(src) { HashMap() }[K + 1] = 0
        val minHeap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }, { it[2] }))
        minHeap.add(intArrayOf(0, src, K + 1))
        while (minHeap.isNotEmpty()) {
            val state = minHeap.remove()
            val result = state[0]
            val u = state[1]
            val k = state[2]
            if (k < 0 || (best[u]?.get(k)?.let { it < result } == true)) {
                continue
            }
            if (u == dst) {
                return result
            }
            for ((v, w) in adj[u].orEmpty()) {
                val next = result + w
                if (best[v]?.get(k - 1)?.let { next >= it } != true) {
                    best.getOrPut(v) { HashMap() }[k - 1] = next
                    minHeap.add(intArrayOf(next, v, k - 1))
                }
            }
        }
        return -1
    }
}
