package countnumberoftrapezoidsii

// Time:  O(n^2 * logr), r = max(max(abs(x), abs(y)) for x, y in points)
// Space: O(n^2)

import kotlin.math.abs

class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val lookupSlope = HashMap<List<Int>, Int>()
        val lookupLine = HashMap<List<Int>, Int>()
        val lookupSlopeLength = HashMap<List<Int>, Int>()
        val lookupLineLength = HashMap<List<Int>, Int>()
        var result = 0
        var same = 0
        for (i in points.indices) {
            val x1 = points[i][0]
            val y1 = points[i][1]
            for (j in 0 until i) {
                val x2 = points[j][0]
                val y2 = points[j][1]
                val dx = x2 - x1
                val dy = y2 - y1
                val g = gcd(dx, dy)
                var a = dx / g
                var b = dy / g
                if (a < 0 || (a == 0 && b < 0)) {
                    a = -a
                    b = -b
                }
                val c = b * x1 - a * y1
                val slope = listOf(a, b)
                val line = listOf(a, b, c)
                result += (lookupSlope[slope] ?: 0) - (lookupLine[line] ?: 0)
                lookupSlope[slope] = (lookupSlope[slope] ?: 0) + 1
                lookupLine[line] = (lookupLine[line] ?: 0) + 1
                val l = dx * dx + dy * dy
                val slopeLength = listOf(a, b, l)
                val lineLength = listOf(a, b, c, l)
                same += (lookupSlopeLength[slopeLength] ?: 0) - (lookupLineLength[lineLength] ?: 0)
                lookupSlopeLength[slopeLength] = (lookupSlopeLength[slopeLength] ?: 0) + 1
                lookupLineLength[lineLength] = (lookupLineLength[lineLength] ?: 0) + 1
            }
        }
        return result - same / 2
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = abs(a)
        var y = abs(b)
        while (y != 0) {
            val next = x % y
            x = y
            y = next
        }
        return x
    }
}
