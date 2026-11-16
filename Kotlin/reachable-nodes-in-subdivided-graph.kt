package reachablenodesinsubdividedgraph
// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|),
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)
import java.util.PriorityQueue

class Solution {
    fun reachableNodes(edges: Array<IntArray>, M: Int, N: Int): Int {
        val adj = Array(N) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            adj[u].add(v to w)
            adj[v].add(u to w)
        }
        val best = HashMap<Int, Int>()
        best[0] = 0
        val count = HashMap<Int, HashMap<Int, Int>>()
        var result = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        minHeap.add(0 to 0)
        while (minHeap.isNotEmpty()) {
            val (currentTotal, u) = minHeap.poll()
            if (best.containsKey(u) && best[u]!! < currentTotal) {
                continue
            }
            result++
            for ((v, w) in adj[u]) {
                count.getOrPut(u) { HashMap() }[v] = minOf(w, M - currentTotal)
                val nextTotal = currentTotal + w + 1
                if (nextTotal <= M && (!best.containsKey(v) || nextTotal < best[v]!!)) {
                    best[v] = nextTotal
                    minHeap.add(nextTotal to v)
                }
            }
        }
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            val w = edge[2]
            result += minOf(w, (count[u]?.get(v) ?: 0) + (count[v]?.get(u) ?: 0))
        }
        return result
    }
}
