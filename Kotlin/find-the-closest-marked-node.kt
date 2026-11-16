package findtheclosestmarkednode

import java.util.PriorityQueue

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)
class Solution {
    fun minimumDistance(n: Int, edges: Array<IntArray>, s: Int, marked: IntArray): Int {
        val target = marked.toHashSet()
        val adj = List(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
        }
        val best = IntArray(adj.size) { Int.MAX_VALUE }
        best[s] = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        minHeap.add(Pair(0, s))
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.poll()
            if (curr > best[u]) {
                continue
            }
            if (u in target) {
                return curr
            }
            for ((v, w) in adj[u]) {
                if (best[v] - curr <= w) {
                    continue
                }
                best[v] = curr + w
                minHeap.add(Pair(curr + w, v))
            }
        }
        return -1
    }
}
