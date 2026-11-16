package maximumpointsinsidethesquare
// Time:  O(n + 26)
// Space: O(26)

import kotlin.math.abs

class Solution {
    fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
        val lookup = IntArray(26) { Int.MAX_VALUE }
        var d = Int.MAX_VALUE
        for (i in s.indices) {
            var secondMinimum = maxOf(abs(points[i][0]), abs(points[i][1]))
            val tag = s[i] - 'a'
            if (secondMinimum < lookup[tag]) {
                val temp = secondMinimum
                secondMinimum = lookup[tag]
                lookup[tag] = temp
            }
            d = minOf(d, secondMinimum)
        }
        var result = 0
        for (x in lookup) {
            if (x < d) {
                ++result
            }
        }
        return result
    }
}
