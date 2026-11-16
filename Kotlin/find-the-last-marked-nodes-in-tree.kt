package findthelastmarkednodesintree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun lastMarkedNodes(edges: Array<IntArray>): IntArray {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        fun bfs(root: Int): Pair<IntArray, Int> {
            var newRoot = -1
            val dist = IntArray(adj.size) { -1 }
            dist[root] = 0
            var q = mutableListOf(root)
            while (q.isNotEmpty()) {
                newRoot = q[0]
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    for (v in adj[u]) {
                        if (dist[v] != -1) {
                            continue
                        }
                        dist[v] = dist[u] + 1
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            return dist to newRoot
        }

        val (_, u) = bfs(0)
        val (dist1, v) = bfs(u)
        val (dist2, _) = bfs(v)
        val result = IntArray(adj.size)
        for (w in adj.indices) {
            result[w] = if (dist1[w] > dist2[w]) u else v
        }
        return result
    }
}
