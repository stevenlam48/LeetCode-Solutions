package minimumcostwalkinweightedgraph

// Time:  O(n + e + q)
// Space: O(n)

class Solution {
    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val uf = UnionFind(n)
        for (e in edges) {
            uf.unionSet(e[0], e[1], e[2])
        }
        val result = IntArray(query.size) { -1 }
        for (i in query.indices) {
            if (uf.findSet(query[i][0]) != uf.findSet(query[i][1])) {
                continue
            }
            result[i] = if (query[i][0] != query[i][1]) uf.cost(query[i][0]) else 0
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val w = IntArray(n) { -1 }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x0: Int, y0: Int, weight: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                w[x] = w[x] and weight
                return false
            }
            if (rank[x] > rank[y]) {
                val tmp = x
                x = y
                y = tmp
            }
            set[x] = y
            if (rank[x] == rank[y]) {
                ++rank[y]
            }
            w[y] = w[y] and w[x] and weight
            return true
        }

        fun cost(x: Int): Int {
            return w[findSet(x)]
        }
    }
}
