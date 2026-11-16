package checkforcontradictionsinequations

import kotlin.math.abs

// Time:  O(e + q)
// Space: O(n)

class Solution {
    fun checkContradictions(equations: List<List<String>>, values: DoubleArray): Boolean {
        val uf = UnionFind()
        for (i in equations.indices) {
            if (!uf.unionSet(equations[i][0], equations[i][1], values[i]) &&
                abs(uf.querySet(equations[i][0], equations[i][1]) - values[i]) > EPS
            ) {
                return true
            }
        }
        return false
    }

    private class UnionFind {
        private val set = HashMap<String, Pair<String, Double>>()
        private val rank = HashMap<String, Int>()

        fun findSet(x: String): Pair<String, Double> {
            if (x !in set) {
                set[x] = Pair(x, 1.0)
            }
            val (xp, xr) = set[x]!!
            if (x != xp) {
                val (pp, pr) = findSet(xp)
                set[x] = Pair(pp, xr * pr)
            }
            return set[x]!!
        }

        fun unionSet(x: String, y: String, r: Double): Boolean {
            val (xp, xr) = findSet(x)
            val (yp, yr) = findSet(y)
            if (xp == yp) {
                return false
            }
            val xRank = rank[xp] ?: 0
            val yRank = rank[yp] ?: 0
            if (xRank < yRank) {
                set[xp] = Pair(yp, r * yr / xr)
            } else if (xRank > yRank) {
                set[yp] = Pair(xp, 1.0 / r * xr / yr)
            } else {
                set[yp] = Pair(xp, 1.0 / r * xr / yr)
                rank[xp] = xRank + 1
            }
            return true
        }

        fun querySet(x: String, y: String): Double {
            if (x !in set || y !in set) {
                return -1.0
            }
            val (xp, xr) = findSet(x)
            val (yp, yr) = findSet(y)
            return if (xp == yp) xr / yr else -1.0
        }
    }

    private companion object {
        const val EPS = 1e-5
    }
}
