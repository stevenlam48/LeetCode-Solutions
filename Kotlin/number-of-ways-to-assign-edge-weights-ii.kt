package numberofwaystoassignedgeweightsii

// Time:  O(n + q)
// Space: O(n + q)

class UnionFind(n: Int) {
    private val set_ = IntArray(n) { it }
    private val rank_ = IntArray(n)

    fun findSet(x0: Int): Int {
        var x = x0
        val stk = ArrayList<Int>()
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
            val tmp = x
            x = y
            y = tmp
        }
        set_[x] = y
        if (rank_[x] == rank_[y]) {
            ++rank_[y]
        }
        return true
    }
}

class Solution {
    fun assignEdgeWeights(edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val MOD = 1_000_000_007

        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0] - 1].add(e[1] - 1)
            adj[e[1] - 1].add(e[0] - 1)
        }
        val lookup = BooleanArray(adj.size)
        val lookup2 = Array(adj.size) { mutableListOf<Int>() }
        for (i in queries.indices) {
            for (x in queries[i]) {
                lookup2[x - 1].add(i)
            }
        }
        val uf = UnionFind(adj.size)
        val ancestor = IntArray(adj.size) { it }
        val dist = IntArray(adj.size)
        val result = IntArray(queries.size)
        val stk = ArrayList<IntArray>()
        stk.add(intArrayOf(1, 0, -1, -1))
        while (stk.isNotEmpty()) {
            val top = stk.removeAt(stk.size - 1)
            val step = top[0]
            val u = top[1]
            val p = top[2]
            val i = top[3]
            if (step == 1) {
                for (qi in lookup2[u]) {
                    if (queries[qi][0] == queries[qi][1]) {
                        continue
                    }
                    result[qi] += dist[u]
                    for (x in queries[qi]) {
                        if (lookup[x - 1]) {
                            result[qi] -= 2 * dist[ancestor[uf.findSet(x - 1)]]
                        }
                    }
                }
                lookup[u] = true
                stk.add(intArrayOf(2, u, -1, 0))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                val v = adj[u][i]
                stk.add(intArrayOf(2, u, -1, i + 1))
                if (lookup[v]) {
                    continue
                }
                dist[v] = dist[u] + 1
                stk.add(intArrayOf(3, v, u, -1))
                stk.add(intArrayOf(1, v, -1, -1))
            } else if (step == 3) {
                uf.unionSet(u, p)
                ancestor[uf.findSet(p)] = p
            }
        }
        val pow2 = IntArray(adj.size - 1) { 1 }
        for (i in 0 until pow2.size - 1) {
            pow2[i + 1] = (pow2[i].toLong() * 2 % MOD).toInt()
        }
        val ret = IntArray(result.size)
        for (i in ret.indices) {
            ret[i] = if (result[i] - 1 >= 0) pow2[result[i] - 1] else 0
        }
        return ret
    }
}
