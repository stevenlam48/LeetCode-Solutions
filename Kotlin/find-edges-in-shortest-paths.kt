package findedgesinshortestpaths

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

// dijkstra's algorithm
class Solution {
    fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
        val INF = Int.MAX_VALUE.toLong()

        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(e[1] to e[2])
            adj[e[1]].add(e[0] to e[2])
        }
        fun dijkstra(start: Int): LongArray {
            val best = LongArray(adj.size) { INF }
            best[start] = 0
            val minHeap = java.util.PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))
            minHeap.add(0L to start)
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.poll()
                if (curr > best[u]) {
                    continue
                }
                for ((v, w) in adj[u]) {
                    if (best[v] - curr <= w) {
                        continue
                    }
                    best[v] = curr + w
                    minHeap.add(best[v] to v)
                }
            }
            return best
        }

        val dist1 = dijkstra(0)
        val dist2 = dijkstra(n - 1)
        val result = BooleanArray(edges.size)
        for (i in edges.indices) {
            val e = edges[i]
            result[i] = (dist1[e[0]] != INF && dist2[e[1]] != INF && dist1[e[0]] + e[2] + dist2[e[1]] == dist1[n - 1]) ||
                (dist2[e[0]] != INF && dist1[e[1]] != INF && dist2[e[0]] + e[2] + dist1[e[1]] == dist2[0])
        }
        return result
    }
}
