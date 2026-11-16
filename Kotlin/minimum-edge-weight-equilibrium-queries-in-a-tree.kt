package minimumedgeweightequilibriumqueriesinatree

// Time:  O(r * (n + q)), r = max(w for _, _, w in edges)
// Space: O(r * n + q)

// Tarjan's Offline LCA Algorithm
class Solution {
    private val MAX_W = 26

    fun minOperationsQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(n) { ArrayList<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2] - 1))
            adj[e[1]].add(Pair(e[0], e[2] - 1))
        }
        val pairs = HashMap<Int, HashSet<Int>>()
        for (q in queries) {
            pairs.getOrPut(q[0]) { HashSet() }.add(q[1])
            pairs.getOrPut(q[1]) { HashSet() }.add(q[0])
        }
        val treeInfos = TreeInfos(adj, pairs)
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val a = queries[i][0]
            val b = queries[i][1]
            val lca = treeInfos.lca(a, b)
            var mx = 0
            for (w in 0 until MAX_W) {
                mx = maxOf(mx, treeInfos.count(a, w) + treeInfos.count(b, w) - 2 * treeInfos.count(lca, w))
            }
            result[i] = (treeInfos.depth(a) + treeInfos.depth(b) - 2 * treeInfos.depth(lca)) - mx
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set_ = IntArray(n) { it }
        private val rank_ = IntArray(n)
        private val ancestor_ = IntArray(n) { it }

        fun find_set(x: Int): Int {
            var x = x
            if (set_[x] != x) {
                set_[x] = find_set(set_[x])
            }
            return set_[x]
        }

        fun union_set(x0: Int, y0: Int): Boolean {
            var x = find_set(x0)
            var y = find_set(y0)
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

        fun find_ancestor_of_set(x: Int): Int {
            return ancestor_[find_set(x)]
        }

        fun update_ancestor_of_set(x: Int) {
            ancestor_[find_set(x)] = x
        }
    }

    private class TreeInfos(
        private val adj: Array<ArrayList<Pair<Int, Int>>>,
        private val pairs: HashMap<Int, HashSet<Int>>,
    ) {
        private val D_ = IntArray(adj.size)
        private val uf_ = UnionFind(adj.size)
        private val lca_ = HashMap<Int, HashMap<Int, Int>>()
        private val lookup_ = BooleanArray(adj.size)
        private val CNT_ = Array(adj.size) { IntArray(MAX_W) }
        private val cnt_ = IntArray(MAX_W)

        init {
            dfs(0, -1)
        }

        fun lca(a0: Int, b0: Int): Int {
            var a = a0
            var b = b0
            if (a > b) {
                val t = a
                a = b
                b = t
            }
            return lca_[a]!![b]!!
        }

        fun depth(a: Int): Int {
            return D_[a]
        }

        fun count(a: Int, w: Int): Int {
            return CNT_[a][w]
        }

        private fun dfs(u: Int, p: Int) {
            D_[u] = if (p == -1) 1 else D_[p] + 1
            CNT_[u] = cnt_.copyOf()
            for ((v, w) in adj[u]) {
                if (v == p) {
                    continue
                }
                ++cnt_[w]
                dfs(v, u)
                --cnt_[w]
                uf_.union_set(v, u)
                uf_.update_ancestor_of_set(u)
            }
            lookup_[u] = true
            if (!pairs.containsKey(u)) {
                return
            }
            for (v in pairs[u]!!) {
                if (!lookup_[v]) {
                    continue
                }
                lca_.getOrPut(minOf(u, v)) { HashMap() }[maxOf(u, v)] = uf_.find_ancestor_of_set(v)
            }
        }

        companion object {
            private const val MAX_W = 26
        }
    }
}
