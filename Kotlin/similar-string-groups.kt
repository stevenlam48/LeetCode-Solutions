package similarstringgroups

// Time:  O(n^2 * l), l is the average length of words
// Space: O(n)
class Solution {
    fun numSimilarGroups(A: List<String>): Int {
        val unionFind = UnionFind(A.size)
        for (i in A.indices) {
            for (j in 0 until i) {
                if (isSimilar(A[i], A[j])) {
                    unionFind.unionSet(i, j)
                }
            }
        }
        return unionFind.size()
    }

    private fun isSimilar(a: String, b: String): Boolean {
        var diff = 0
        for (i in a.indices) {
            if (a[i] != b[i] && ++diff > 2) return false
        }
        return diff == 2
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var size = n

        private fun findSet(x: Int): Int {
            if (set[x] != x) set[x] = findSet(set[x])
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) return false
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            --size
            return true
        }

        fun size(): Int = size
    }
}
