package findthecitywiththesmallestnumberofneighborsatathresholddistance

// Time:  O(n^3)
// Space: O(n^2)
class Solution {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        for (e in edges) {
            dist[e[0]][e[1]] = e[2]
            dist[e[1]][e[0]] = e[2]
        }
        for (i in 0 until n) {
            dist[i][i] = 0
        }
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE) {
                        dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                    }
                }
            }
        }
        var result = -1
        var minNum = Int.MAX_VALUE
        for (i in n - 1 downTo 0) {
            val num = dist[i].count { it <= distanceThreshold }
            if (num < minNum) {
                minNum = num
                result = i
            }
        }
        return result
    }
}
