package ranktransformofamatrix
// Time:  O(m * n * log(m * n) + m * n * α(m * n)) = O(m * n * log(m * n))
// Space: O(m * n)
import java.util.TreeMap

class Solution {
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val lookup = TreeMap<Int, MutableList<Pair<Int, Int>>>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                lookup.getOrPut(matrix[i][j]) { mutableListOf() }.add(i to j)
            }
        }
        val rank = IntArray(matrix.size + matrix[0].size)
        for (pairs in lookup.values) {
            val newRank = rank.copyOf()
            val unionFind = UnionFind(matrix.size + matrix[0].size) { x, y, z ->
                newRank[x] = maxOf(newRank[y], newRank[z])
            }
            for ((i, j) in pairs) {
                unionFind.unionSet(i, j + matrix.size)
            }
            for ((i, j) in pairs) {
                val value = newRank[unionFind.findSet(i)] + 1
                matrix[i][j] = value
                rank[i] = value
                rank[j + matrix.size] = value
            }
        }
        return matrix
    }

    private class UnionFind(
        n: Int,
        private val callback: (Int, Int, Int) -> Unit
    ) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

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
                callback(yRoot, xRoot, yRoot)
            } else if (rank[xRoot] > rank[yRoot]) {
                set[yRoot] = xRoot
                callback(xRoot, xRoot, yRoot)
            } else {
                set[yRoot] = xRoot
                rank[xRoot]++
                callback(xRoot, xRoot, yRoot)
            }
            return true
        }
    }
}
