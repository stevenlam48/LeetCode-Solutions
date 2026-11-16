package minimumtimetoreachdestinationindirectedgraph

// Time:  O(n + elogn)
// Space: O(n + e)

import java.util.PriorityQueue

class Solution {
    fun minTime(n: Int, edges: Array<IntArray>): Int {
        val adjacency = Array(n) { mutableListOf<Triple<Int, Int, Int>>() }
        for (edge in edges) {
            adjacency[edge[0]].add(Triple(edge[1], edge[2], edge[3]))
        }
        val best = IntArray(n) { Int.MAX_VALUE }
        best[0] = 0
        val heap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        heap.add(0 to 0)
        while (heap.isNotEmpty()) {
            val (current, u) = heap.poll()
            if (current != best[u]) {
                continue
            }
            if (u == n - 1) {
                return current
            }
            for ((v, start, end) in adjacency[u]) {
                if (current > end) {
                    continue
                }
                val arrival = maxOf(current, start) + 1
                if (best[v] > arrival) {
                    best[v] = arrival
                    heap.add(arrival to v)
                }
            }
        }
        return -1
    }
}
