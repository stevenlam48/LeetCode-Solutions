package mincosttoconnectallpoints

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var result = 0
        var u = 0
        val dist = IntArray(points.size) { Int.MAX_VALUE }
        val lookup = HashSet<Int>()
        for (i in 0 until points.size - 1) {
            val x0 = points[u][0]
            val y0 = points[u][1]
            lookup.add(u)
            for (v in points.indices) {
                if (lookup.contains(v)) {
                    continue
                }
                dist[v] = minOf(dist[v], kotlin.math.abs(points[v][0] - x0) + kotlin.math.abs(points[v][1] - y0))
            }
            var value = Int.MAX_VALUE
            for (v in dist.indices) {
                if (dist[v] < value) {
                    value = dist[v]
                    u = v
                }
            }
            dist[u] = Int.MAX_VALUE
            result += value
        }
        return result
    }
}
