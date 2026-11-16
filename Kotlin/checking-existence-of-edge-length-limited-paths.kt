package checkingexistenceofedgelengthlimitedpaths

// Time:  O(nlogn + mlogm + n * α(n)) = O(nlogn + mlogm)
// Space: O(n)

class Solution {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val qs = Array(queries.size) { i ->
            intArrayOf(queries[i][0], queries[i][1], queries[i][2], i)
        }
        edgeList.sortWith(compareBy { it[2] })
        qs.sortWith(compareBy { it[2] })

        val unionFind = UnionFind(n)
        val result = BooleanArray(qs.size)
        var curr = 0
        for (q in qs) {
            val u = q[0]
            val v = q[1]
            val w = q[2]
            val i = q[3]
            while (curr < edgeList.size && edgeList[curr][2] < w) {
                unionFind.unionSet(edgeList[curr][0], edgeList[curr][1])
                ++curr
            }
            result[i] = unionFind.findSet(u) == unionFind.findSet(v)
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set_ = IntArray(n) { it }
        private val rank_ = IntArray(n)
        private var count_ = n

        fun findSet(x: Int): Int {
            if (set_[x] != x) {
                set_[x] = findSet(set_[x])
            }
            return set_[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank_[xRoot] < rank_[yRoot]) {
                set_[xRoot] = yRoot
            } else if (rank_[xRoot] > rank_[yRoot]) {
                set_[yRoot] = xRoot
            } else {
                set_[yRoot] = xRoot
                ++rank_[xRoot]
            }
            --count_
            return true
        }

        fun size(): Int {
            return count_
        }
    }
}
