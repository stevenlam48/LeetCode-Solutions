package minimumcosttoreachcitywithdiscounts

import java.util.PriorityQueue

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

class Solution {
    fun minimumCost(n: Int, highways: Array<IntArray>, discounts: Int): Int {
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (highway in highways) {
            val u = highway[0]
            val v = highway[1]
            val w = highway[2]
            adj.getOrPut(u) { mutableListOf() }.add(Pair(v, w))
            adj.getOrPut(v) { mutableListOf() }.add(Pair(u, w))
        }

        val best = HashMap<Int, HashMap<Int, Int>>()
        best[0] = HashMap()
        best[0]!![discounts] = 0
        val minHeap = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        minHeap.add(Triple(0, 0, discounts))
        while (minHeap.isNotEmpty()) {
            val (total, u, k) = minHeap.poll()
            val current = best[u]?.get(k)
            if (current != null && current < total) {
                continue
            }
            if (u == n - 1) {
                return total
            }
            for ((v, w) in adj[u] ?: emptyList()) {
                val bestVK = best[v]?.get(k)
                if (bestVK == null || total + w < bestVK) {
                    best.getOrPut(v) { HashMap() }[k] = total + w
                    minHeap.add(Triple(total + w, v, k))
                }
                if (k > 0) {
                    val bestVK1 = best[v]?.get(k - 1)
                    if (bestVK1 == null || total + w / 2 < bestVK1) {
                        best.getOrPut(v) { HashMap() }[k - 1] = total + w / 2
                        minHeap.add(Triple(total + w / 2, v, k - 1))
                    }
                }
            }
        }
        return -1
    }
}
