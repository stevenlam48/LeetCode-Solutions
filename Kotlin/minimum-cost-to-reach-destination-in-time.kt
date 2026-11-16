package minimumcosttoreachdestinationintime

import java.util.PriorityQueue

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|),
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

class Solution {
    fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            adj.getOrPut(u) { mutableListOf() }.add(Pair(v, w))
            adj.getOrPut(v) { mutableListOf() }.add(Pair(u, w))
        }

        val best = HashMap<Int, Int>()
        best[0] = 0
        val minHeap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        minHeap.add(Triple(passingFees[0], 0, 0))
        while (minHeap.isNotEmpty()) {
            val (result, u, w) = minHeap.poll()
            if (w > maxTime) {
                continue
            }
            if (u == passingFees.size - 1) {
                return result
            }
            for ((v, nw) in adj[u] ?: emptyList()) {
                val bestV = best[v]
                if (bestV == null || w + nw < bestV) {
                    best[v] = w + nw
                    minHeap.add(Triple(result + passingFees[v], v, w + nw))
                }
            }
        }
        return -1
    }
}
