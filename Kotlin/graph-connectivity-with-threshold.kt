package graphconnectivitywiththreshold

// Time:  O((nlogn + q) * α(n)) ~= O(nlogn + q)
// Space: O(n)

class Solution {
    fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): BooleanArray {
        val unionFind = UnionFind(n)
        for (i in threshold + 1..n) {
            for (j in 2 * i..n step i) {
                unionFind.unionSet(i - 1, j - 1)
            }
        }
        return BooleanArray(queries.size) { i ->
            unionFind.findSet(queries[i][0] - 1) == unionFind.findSet(queries[i][1] - 1)
        }
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private var count = n

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank[xRoot] < rank[yRoot]) {
                set[xRoot] = yRoot
            } else if (rank[xRoot] > rank[yRoot]) {
                set[yRoot] = xRoot
            } else {
                set[yRoot] = xRoot
                rank[xRoot]++
            }
            count--
            return true
        }

        fun size(): Int = count
    }
}
