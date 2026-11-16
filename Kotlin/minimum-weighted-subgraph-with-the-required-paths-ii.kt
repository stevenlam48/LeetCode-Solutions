package minimumweightedsubgraphwiththerequiredpathsii

class UnionFind(n: Int) {
    private val set_ = IntArray(n) { it }
    private val rank_ = IntArray(n)

    fun findSet(x0: Int): Int {
        var x = x0
        val stk = mutableListOf<Int>()
        while (set_[x] != x) {
            stk.add(x)
            x = set_[x]
        }
        while (stk.isNotEmpty()) {
            val y = stk.removeAt(stk.size - 1)
            set_[y] = x
        }
        return x
    }

    fun unionSet(x0: Int, y0: Int): Boolean {
        var x = findSet(x0)
        var y = findSet(y0)
        if (x == y) {
            return false
        }
        if (rank_[x] > rank_[y]) {
            val t = x
            x = y
            y = t
        }
        set_[x] = y
        if (rank_[x] == rank_[y]) {
            ++rank_[y]
        }
        return true
    }
}

// Time:  O(n + q)
// Space: O(n + q)

// iterative dfs, Tarjan's Offline LCA Algorithm
class Solution {
    fun minimumWeight(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(edges.size + 1) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
            adj[e[1]].add(Pair(e[0], e[2]))
        }
        val lookup = BooleanArray(adj.size)
        val lookup2 = Array(adj.size) { mutableListOf<Int>() }
        for (i in queries.indices) {
            for (x in queries[i]) {
                lookup2[x].add(i)
            }
        }
        val uf = UnionFind(adj.size)
        val ancestor = IntArray(adj.size) { it }
        val dist = IntArray(adj.size)
        val result = IntArray(queries.size)
        val stk = java.util.ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, 0, -1, -1))
        while (stk.isNotEmpty()) {
            val cur = stk.pollLast()
            val step = cur[0]
            val u = cur[1]
            val p = cur[2]
            val i = cur[3]
            if (step == 1) {
                for (qi in lookup2[u]) {
                    result[qi] += dist[u]
                    for (x in queries[qi]) {
                        if (lookup[x]) {
                            result[qi] -= dist[ancestor[uf.findSet(x)]]
                        }
                    }
                }
                lookup[u] = true
                stk.addLast(intArrayOf(2, u, -1, 0))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                val (v, w) = adj[u][i]
                stk.addLast(intArrayOf(2, u, -1, i + 1))
                if (lookup[v]) {
                    continue
                }
                dist[v] = dist[u] + w
                stk.addLast(intArrayOf(3, v, u, -1))
                stk.addLast(intArrayOf(1, v, -1, -1))
            } else if (step == 3) {
                uf.unionSet(u, p)
                ancestor[uf.findSet(p)] = p
            }
        }
        return result
    }
}
