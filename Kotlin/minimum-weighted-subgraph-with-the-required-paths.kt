package minimumweightedsubgraphwiththerequiredpaths

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|),
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

// dijkstra's algorithm
class Solution {
    fun minimumWeight(n: Int, edges: Array<IntArray>, src1: Int, src2: Int, dest: Int): Long {
        val adj1 = Array(n) { mutableListOf<Pair<Int, Int>>() }
        val adj2 = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj1[e[0]].add(Pair(e[1], e[2]))
            adj2[e[1]].add(Pair(e[0], e[2]))
        }
        val dist1 = dijkstra(adj1, src1)
        val dist2 = dijkstra(adj1, src2)
        val dist3 = dijkstra(adj2, dest)
        var result = INF
        for (i in 0 until n) {
            if (dist1[i] != INF && dist2[i] != INF && dist3[i] != INF) {
                result = minOf(result, dist1[i] + dist2[i] + dist3[i])
            }
        }
        return if (result != INF) result else -1
    }

    private fun dijkstra(adj: Array<MutableList<Pair<Int, Int>>>, start: Int): LongArray {
        val best = LongArray(adj.size) { INF }
        best[start] = 0
        val minHeap = java.util.PriorityQueue<Pair<Long, Int>>(compareBy { it.first })
        minHeap.add(Pair(0L, start))
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.poll()
            if (best[u] < curr) {
                continue
            }
            for ((v, w) in adj[u]) {
                if (best[v] - curr <= w) {
                    continue
                }
                best[v] = curr + w
                minHeap.add(Pair(curr + w, v))
            }
        }
        return best
    }

    private val INF = Long.MAX_VALUE
}
