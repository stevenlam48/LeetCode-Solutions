package closestnodetopathintree

// Time:  O(n + q)
// Space: O(n + q)

class Solution {
    fun closestNode(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val pairs = HashMap<Int, MutableSet<Int>>()
        for (q in query) {
            pairs.getOrPut(q[0]) { HashSet() }.add(q[1])
            pairs.getOrPut(q[1]) { HashSet() }.add(q[0])
            pairs.getOrPut(q[0]) { HashSet() }.add(q[2])
            pairs.getOrPut(q[2]) { HashSet() }.add(q[0])
            pairs.getOrPut(q[1]) { HashSet() }.add(q[2])
            pairs.getOrPut(q[2]) { HashSet() }.add(q[1])
        }
        val treeInfos = TreeInfos(adj, pairs)
        val result = ArrayList<Int>()
        for (q in query) {
            val candidates = intArrayOf(
                treeInfos.lca(q[0], q[1]),
                treeInfos.lca(q[0], q[2]),
                treeInfos.lca(q[1], q[2])
            )
            var best = candidates[0]
            for (i in 1 until candidates.size) {
                if (treeInfos.depth(best) < treeInfos.depth(candidates[i])) {
                    best = candidates[i]
                }
            }
            result.add(best)
        }
        return result.toIntArray()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val ancestor = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            var a = findSet(x)
            var b = findSet(y)
            if (a == b) {
                return false
            }
            if (rank[a] > rank[b]) {
                val temp = a
                a = b
                b = temp
            }
            set[a] = b
            if (rank[a] == rank[b]) {
                ++rank[b]
            }
            return true
        }

        fun findAncestorOfSet(x: Int): Int {
            return ancestor[findSet(x)]
        }

        fun updateAncestorOfSet(x: Int) {
            ancestor[findSet(x)] = x
        }
    }

    private class TreeInfos(adj: Array<MutableList<Int>>, pairs: HashMap<Int, MutableSet<Int>>) {
        private val depths = IntArray(adj.size)
        private val uf = UnionFind(adj.size)
        private val lookup = BooleanArray(adj.size)
        private val lcas = HashMap<Int, HashMap<Int, Int>>()

        init {
            dfs(adj, pairs, 0, -1)
        }

        fun lca(a: Int, b: Int): Int {
            val x = minOf(a, b)
            val y = maxOf(a, b)
            return lcas[x]!![y]!!
        }

        fun depth(a: Int): Int {
            return depths[a]
        }

        private fun dfs(
            adj: Array<MutableList<Int>>,
            pairs: HashMap<Int, MutableSet<Int>>,
            curr: Int,
            parent: Int
        ) {
            depths[curr] = if (parent == -1) 1 else depths[parent] + 1
            for (child in adj[curr]) {
                if (child == parent) {
                    continue
                }
                dfs(adj, pairs, child, curr)
                uf.unionSet(child, curr)
                uf.updateAncestorOfSet(curr)
            }
            lookup[curr] = true
            if (!pairs.containsKey(curr)) {
                return
            }
            for (v in pairs[curr]!!) {
                if (!lookup[v]) {
                    continue
                }
                lcas.getOrPut(minOf(curr, v)) { HashMap() }[maxOf(curr, v)] = uf.findAncestorOfSet(v)
            }
        }
    }
}
