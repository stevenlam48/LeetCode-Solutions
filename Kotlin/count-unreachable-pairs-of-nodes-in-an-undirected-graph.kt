package countunreachablepairsofnodesinanundirectedgraph

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val lookup = BooleanArray(n)

        fun bfs(u: Int): Long {
            var q = listOf(u)
            lookup[u] = true
            var result = 1L
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (node in q) {
                    for (v in adj[node]) {
                        if (lookup[v]) {
                            continue
                        }
                        lookup[v] = true
                        ++result
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            return result
        }

        var result = 0L
        var remaining = n
        for (u in adj.indices) {
            if (lookup[u]) {
                continue
            }
            val count = bfs(u)
            result += count * (remaining - count)
            remaining -= count.toInt()
        }
        return result
    }
}
