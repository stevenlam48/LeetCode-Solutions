package minimumcostpathwithedgereversals

// Time:  O(n + elogn)
// Space: O(n + e)

class Solution {
    fun minCost(n: Int, edges: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
            adj[e[1]].add(Pair(e[0], 2 * e[2]))
        }
        val best = IntArray(n) { INF }
        best[0] = 0
        val minHeap = java.util.PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        minHeap.add(Pair(0, 0))
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.poll()
            if (curr != best[u]) {
                continue
            }
            if (u == n - 1) {
                return curr
            }
            for ((v, w) in adj[u]) {
                if (!(best[v] > curr + w)) {
                    continue
                }
                best[v] = curr + w
                minHeap.add(Pair(best[v], v))
            }
        }
        return -1
    }
}
