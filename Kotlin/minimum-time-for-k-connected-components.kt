package minimumtimeforkconnectedcomponents

// Time:  O(n + eloge)
// Space: O(n)

class Solution {
    fun minTime(n: Int, edges: Array<IntArray>, k: Int): Int {
        edges.sortWith(compareByDescending { it[2] })
        var cnt = 0
        val uf = UnionFind(n)
        for (e in edges) {
            if (!uf.unionSet(e[0], e[1])) {
                continue
            }
            if (cnt == n - k) {
                return e[2]
            }
            ++cnt
        }
        return 0
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

        fun findSet(x0: Int): Int {
            var x = x0
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x0: Int, y0: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
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
            return true
        }
    }
}
