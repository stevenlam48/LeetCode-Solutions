package minimizemaximumcomponentcost
// Time:  O(n + eloge)
// Space: O(n)

class Solution {
    fun minCost(n: Int, edges: Array<IntArray>, k: Int): Int {
        edges.sortBy { it[2] }
        var cnt = 0
        val uf = UnionFind(n)
        for (e in edges) {
            if (!uf.unionSet(e[0], e[1])) {
                continue
            }
            if (++cnt == n - k) {
                return e[2]
            }
        }
        return 0
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            var rootX = findSet(x)
            var rootY = findSet(y)
            if (rootX == rootY) {
                return false
            }
            if (rank[rootX] > rank[rootY]) {
                val temp = rootX
                rootX = rootY
                rootY = temp
            }
            set[rootX] = rootY
            if (rank[rootX] == rank[rootY]) {
                ++rank[rootY]
            }
            return true
        }
    }
}
