package modifygraphedgeweights
// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

import java.util.PriorityQueue

class Solution {
    fun modifiedGraphEdges(n: Int, edges: Array<IntArray>, source: Int, destination: Int, target: Int): Array<IntArray> {
        val adj = Array(n) { mutableListOf<IntArray>() }
        for (e in edges) {
            adj[e[0]].add(intArrayOf(e[1], e[2]))
            adj[e[1]].add(intArrayOf(e[0], e[2]))
        }

        fun dijkstra(start: Int, x: Int): IntArray {
            val best = IntArray(adj.size) { target + 1 }
            best[start] = 0
            val minHeap = PriorityQueue<Pair<Long, Int>>(compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second })
            minHeap.add(0L to start)
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.remove()
                if (curr > best[u]) {
                    continue
                }
                for ((v, originalWeight) in adj[u]) {
                    val w = if (originalWeight == -1) x else originalWeight
                    if (best[v] - curr <= w) {
                        continue
                    }
                    best[v] = (curr + w).toInt()
                    minHeap.add(curr + w to v)
                }
            }
            return best
        }

        val left = dijkstra(source, 1)
        if (left[destination] > target) {
            return emptyArray()
        }
        val right = dijkstra(destination, target + 1)
        if (right[source] < target) {
            return emptyArray()
        }
        for (e in edges) {
            if (e[2] == -1) {
                e[2] = maxOf(
                    target - left[e[0]] - right[e[1]],
                    target - left[e[1]] - right[e[0]],
                    1
                )
            }
        }
        return edges
    }
}
