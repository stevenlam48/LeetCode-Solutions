package coordinatewithmaximumnetworkquality

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
        var minX = Int.MAX_VALUE
        var maxX = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        for (tower in towers) {
            minX = minOf(minX, tower[0])
            maxX = maxOf(maxX, tower[0])
            minY = minOf(minY, tower[1])
            maxY = maxOf(maxY, tower[1])
        }
        var maxQuality = 0
        var result = IntArray(0)
        for (x in minX..maxX) {
            for (y in minY..maxY) {
                var q = 0
                for (t in towers) {
                    val dx = t[0] - x
                    val dy = t[1] - y
                    val d = Math.sqrt((dx * dx + dy * dy).toDouble())
                    if (d <= radius) {
                        q += (t[2] / (1 + d)).toInt()
                    }
                }
                if (q > maxQuality) {
                    maxQuality = q
                    result = intArrayOf(x, y)
                }
            }
        }
        return result
    }
}
