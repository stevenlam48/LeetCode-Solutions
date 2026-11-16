package minimumdistanceexcludingonemaximumweightededge
// Time:  O(n + elogn)
// Space: O(n + e)

import java.util.PriorityQueue

class Solution {
    fun minCostExcludingMax(n: Int, edges: Array<IntArray>): Long {
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(e[1] to e[2])
            adj[e[1]].add(e[0] to e[2])
        }
        val l = 1
        val dist = Array(l + 1) { LongArray(n) { Long.MAX_VALUE } }
        val excluded = 0
        dist[excluded][0] = 0L
        val minHeap = PriorityQueue<Triple<Long, Int, Int>>(
            compareBy({ it.first }, { it.second }, { it.third })
        )
        minHeap.add(Triple(0L, 0, excluded))
        while (minHeap.isNotEmpty()) {
            val (curr, u, state) = minHeap.remove()
            if (curr != dist[state][u]) {
                continue
            }
            if (u == n - 1) {
                break
            }
            for ((v, w) in adj[u]) {
                if (state <= l - 1 && curr < dist[state + 1][v]) {
                    dist[state + 1][v] = curr
                    minHeap.add(Triple(curr, v, state + 1))
                }
                if (curr + w < dist[state][v]) {
                    dist[state][v] = curr + w
                    minHeap.add(Triple(dist[state][v], v, state))
                }
            }
        }
        return dist[l][n - 1]
    }
}
