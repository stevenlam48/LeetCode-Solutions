package numberofwaystoassignedgeweightsi

// Time:  O(n)
// Space: O(n)

class Solution {
    fun assignEdgeWeights(edges: Array<IntArray>): Int {
        val MOD = 1_000_000_007
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0] - 1].add(e[1] - 1)
            adj[e[1] - 1].add(e[0] - 1)
        }
        var d = -1
        val lookup = BooleanArray(adj.size)
        lookup[0] = true
        var q = mutableListOf(0)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    newQ.add(v)
                }
            }
            q = newQ
            ++d
        }
        var result = 1
        var dd = d - 1
        while (dd > 0) {
            result = (result.toLong() * 2 % MOD).toInt()
            --dd
        }
        return result
    }
}
