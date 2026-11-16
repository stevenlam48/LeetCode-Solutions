package minimumarearectangleii

// Time:  O(n^2) ~ O(n^3)
// Space: O(n^2)

class Solution {
    fun minAreaFreeRect(points: Array<IntArray>): Double {
        points.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        val lookup = HashMap<Pair<Double, Double>, MutableList<Pair<Double, Double>>>()
        for (i in 0 until points.size - 1) {
            for (j in i + 1 until points.size) {
                val diagonal = Pair(
                    (points[i][0] - points[j][0]).toDouble(),
                    (points[i][1] - points[j][1]).toDouble()
                )
                lookup.getOrPut(diagonal) { mutableListOf() }.add(
                    Pair(
                        ((points[i][0] + points[j][0]) / 2).toDouble(),
                        ((points[i][1] + points[j][1]) / 2).toDouble()
                    )
                )
            }
        }
        var result = Double.POSITIVE_INFINITY
        for ((diagonal, midpoints) in lookup) {
            for (i in 0 until midpoints.size - 1) {
                for (j in i + 1 until midpoints.size) {
                    val x1 = diagonal.first
                    val y1 = diagonal.second
                    val x2 = midpoints[i].first - midpoints[j].first
                    val y2 = midpoints[i].second - midpoints[j].second
                    if (x1 * x2 + y1 * y2 == 0.0) {
                        result = minOf(result, kotlin.math.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2)))
                    }
                }
            }
        }
        return if (result != Double.POSITIVE_INFINITY) result else 0.0
    }
}
