package minimumtimetovisitdisappearingnodes

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

import java.util.PriorityQueue

class Solution {
    fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
        val adjacency = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1] to edge[2])
            adjacency[edge[1]].add(edge[0] to edge[2])
        }
        val best = IntArray(n) { -1 }
        best[0] = 0
        val heap = PriorityQueue(compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second })
        heap.add(0L to 0)
        while (heap.isNotEmpty()) {
            val (current, u) = heap.poll()
            if (current != best[u].toLong()) {
                continue
            }
            for ((v, weight) in adjacency[u]) {
                val limit = minOf(if (best[v] != -1) best[v] else Int.MAX_VALUE, disappear[v])
                if (weight >= limit - current) {
                    continue
                }
                best[v] = (current + weight).toInt()
                heap.add(best[v].toLong() to v)
            }
        }
        return best
    }
}
