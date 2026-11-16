package findthenumberofwaystoplacepeoplei

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })

        var result = 0
        for (i in points.indices) {
            var y = Int.MIN_VALUE
            for (j in i + 1 until points.size) {
                if (points[i][1] < points[j][1]) {
                    continue
                }
                if (points[j][1] > y) {
                    y = points[j][1]
                    ++result
                }
            }
        }
        return result
    }
}
