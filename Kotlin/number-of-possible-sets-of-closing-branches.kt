package numberofpossiblesetsofclosingbranches

// Time:  O(r + 2^n * n^2)
// Space: O(n^3)

// graph, bitmasks, Floyd-Warshall algorithm, backtracking
class Solution {
    fun numberOfSets(n: Int, maxDistance: Int, roads: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE

        fun check(mask: Int, dist: Array<IntArray>): Boolean {
            for (i in 0 until n) {
                if (mask and (1 shl i) == 0) {
                    continue
                }
                for (j in i + 1 until n) {
                    if (mask and (1 shl j) == 0) {
                        continue
                    }
                    if (dist[i][j] > maxDistance) {
                        return false
                    }
                }
            }
            return true
        }

        fun floydWarshall(dist: Array<IntArray>, k: Int) {
            for (i in 0 until n) {
                for (j in i + 1 until n) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[j][i] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                        dist[i][j] = dist[j][i]
                    }
                }
            }
        }

        var result = 0

        fun backtracking(i: Int, mask: Int, dist: Array<IntArray>) {
            if (i == n) {
                if (check(mask, dist)) {
                    ++result
                }
                return
            }
            for (j in 0..1) {
                val newDist = Array(n) { dist[it].copyOf() }
                if (j != 0) {
                    floydWarshall(newDist, i)
                }
                backtracking(i + 1, mask or (j shl i), newDist)
            }
        }

        val dist = Array(n) { IntArray(n) { INF } }
        for (u in 0 until n) {
            dist[u][u] = 0
        }
        for (r in roads) {
            dist[r[0]][r[1]] = minOf(dist[r[0]][r[1]], r[2])
            dist[r[1]][r[0]] = minOf(dist[r[1]][r[0]], r[2])
        }
        backtracking(0, 0, dist)
        return result
    }
}
