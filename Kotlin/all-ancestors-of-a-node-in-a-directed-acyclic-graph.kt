package allancestorsofanodeinadirectedacyclicgraph

// Time:  O(|V| * |E|)
// Space: O(|V| + |E|)

// dfs
class Solution {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
        }
        val result = Array(n) { mutableListOf<Int>() }
        for (u in 0 until n) {
            iterDfs(adj, u, result)
        }
        return result.map { it.toList() }
    }

    private fun iterDfs(adj: Array<MutableList<Int>>, i: Int, result: Array<MutableList<Int>>) {
        val lookup = BooleanArray(adj.size)
        val stk = ArrayDeque<Int>()
        stk.addLast(i)
        while (stk.isNotEmpty()) {
            val u = stk.removeLast()
            for (v in adj[u]) {
                if (lookup[v]) {
                    continue
                }
                lookup[v] = true
                stk.addLast(v)
                result[v].add(i)
            }
        }
    }
}
