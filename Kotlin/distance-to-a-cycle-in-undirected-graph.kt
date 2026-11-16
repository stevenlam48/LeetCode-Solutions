package distancetoacycleinundirectedgraph

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

// graph, dfs, bfs
class Solution {
    fun distanceToCycle(n: Int, edges: Array<IntArray>): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        return bfs(adj, iterDfs(adj))
    }

    private fun cycle(parent: IntArray, v: Int, u0: Int): MutableList<Int> {
        var u = u0
        val result = mutableListOf(parent[v], v)
        while (u != parent[v]) {
            result.add(u)
            u = parent[u]
        }
        return result
    }

    private fun iterDfs(adj: Array<MutableList<Int>>): MutableList<Int> {
        val stk = mutableListOf(0)
        val parent = IntArray(adj.size) { -2 }
        parent[0] = -1
        while (stk.isNotEmpty()) {
            val u = stk.removeAt(stk.size - 1)
            for (v in adj[u]) {
                if (parent[v] != -2) {
                    if (v == parent[u]) {
                        continue
                    }
                    return cycle(parent, v, u)
                }
                parent[v] = u
                stk.add(v)
            }
        }
        return mutableListOf()
    }

    private fun bfs(adj: Array<MutableList<Int>>, q0: MutableList<Int>): IntArray {
        var q = q0
        val result = IntArray(adj.size) { -1 }
        for (x in q) {
            result[x] = 0
        }
        var d = 1
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    if (result[v] != -1) {
                        continue
                    }
                    result[v] = d
                    newQ.add(v)
                }
            }
            q = newQ
            ++d
        }
        return result
    }
}
