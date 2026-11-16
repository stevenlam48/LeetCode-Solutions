package friendcircles

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun findCircleNum(M: Array<IntArray>): Int {
        val circles = UnionFind(M.size)
        for (i in M.indices) {
            for (j in M[i].indices) {
                if (M[i][j] != 0 && i != j) {
                    circles.union(i, j)
                }
            }
        }
        return circles.size()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var count = n

        fun find(x0: Int): Int {
            var x = x0
            if (set[x] != x) {
                set[x] = find(set[x])
            }
            return set[x]
        }

        fun union(x: Int, y: Int) {
            val xRoot = find(x)
            val yRoot = find(y)
            if (xRoot != yRoot) {
                set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
                --count
            }
        }

        fun size(): Int = count
    }
}
