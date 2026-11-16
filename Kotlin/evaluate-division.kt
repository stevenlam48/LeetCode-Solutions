package evaluatedivision

// Time:  O((e + q) * α(n)) ~= O(e + q), using either one of "path compression" and "union by rank" results in amortized O(logn)
//                                     , using  both results in α(n) ~= O(1)
// Space: O(n)
class Solution {
    fun calcEquation(
        equations: Array<Array<String>>,
        values: DoubleArray,
        queries: Array<Array<String>>
    ): DoubleArray {
        val unionFind = UnionFind()
        for (i in equations.indices) {
            unionFind.unionSet(equations[i][0], equations[i][1], values[i])
        }

        val result = DoubleArray(queries.size)
        for (i in queries.indices) {
            result[i] = unionFind.querySet(queries[i][0], queries[i][1])
        }
        return result
    }

    private class UnionFind {
        private val set = HashMap<String, Pair<String, Double>>()
        private val rank = HashMap<String, Int>()

        fun findSet(x: String): Pair<String, Double> {
            if (!set.containsKey(x)) {
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
            val rankXp = rank[xp] ?: 0
            val rankYp = rank[yp] ?: 0
            if (rankXp < rankYp) {
                set[xp] = Pair(yp, r * yr / xr)
            } else if (rankXp > rankYp) {
                set[yp] = Pair(xp, 1.0 / r * xr / yr)
            } else {
                set[yp] = Pair(xp, 1.0 / r * xr / yr)
                rank[xp] = rankXp + 1
            }
            return true
        }

        fun querySet(x: String, y: String): Double {
            if (!set.containsKey(x) || !set.containsKey(y)) {
                return -1.0
            }
            val (xp, xr) = findSet(x)
            val (yp, yr) = findSet(y)
            return if (xp == yp) xr / yr else -1.0
        }
    }
}
