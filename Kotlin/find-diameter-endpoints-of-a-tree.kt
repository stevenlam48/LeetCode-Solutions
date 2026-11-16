package finddiameterendpointsofatree

// Time:  O(n)
// Space: O(n)

// tree diameter, bfs
class Solution {
    fun findSpecialNodes(n: Int, edges: Array<IntArray>): String {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        fun bfs(u: Int): List<Int> {
            val lookup = BooleanArray(adj.size)
            lookup[u] = true
            var q = mutableListOf(u)
            var newQ = mutableListOf<Int>()
            while (q.isNotEmpty()) {
                newQ = mutableListOf()
                for (x in q) {
                    for (v in adj[x]) {
                        if (lookup[v]) {
                            continue
                        }
                        lookup[v] = true
                        newQ.add(v)
                    }
                }
                val tmp = q
                q = newQ
                newQ = tmp
            }
            return newQ
        }

        val result = CharArray(n) { '0' }
        val far = bfs(0)
        for (u in far) {
            result[u] = '1'
        }
        for (u in bfs(far[0])) {
            result[u] = '1'
        }
        return String(result)
    }
}
