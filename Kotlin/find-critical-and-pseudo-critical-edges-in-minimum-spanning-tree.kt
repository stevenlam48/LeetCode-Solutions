package findcriticalandpseudocriticaledgesinminimumspanningtree

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): Array<IntArray> {
        val sorted = Array(edges.size) { intArrayOf(edges[it][0], edges[it][1], edges[it][2], it) }
        sorted.sortBy { it[2] }
        val mst = MST(n, sorted)
        val result = arrayOf(mutableListOf<Int>(), mutableListOf<Int>())
        for (i in sorted.indices) {
            if (mst < MST(n, sorted, i)) {
                result[0].add(sorted[i][3])
            } else if (mst == MST(n, sorted, -1, i)) {
                result[1].add(sorted[i][3])
            }
        }
        return arrayOf(result[0].toIntArray(), result[1].toIntArray())
    }

    private fun MST(n: Int, edges: Array<IntArray>, unused: Int = -1, used: Int = -1): Int {
        val unionFind = UnionFind(n)
        var weight = 0
        if (used != -1) {
            val edge = edges[used]
            if (unionFind.unionSet(edge[0], edge[1])) {
                weight += edge[2]
            }
        }
        for (i in edges.indices) {
            if (i == unused) {
                continue
            }
            val edge = edges[i]
            if (unionFind.unionSet(edge[0], edge[1])) {
                weight += edge[2]
            }
        }
        return if (unionFind.size() == 1) weight else Int.MAX_VALUE
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var size = n

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
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            --size
            return true
        }

        fun size(): Int {
            return size
        }
    }
}
