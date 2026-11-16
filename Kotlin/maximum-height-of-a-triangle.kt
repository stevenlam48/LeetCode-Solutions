package maximumheightofatriangle

// Time:  O(logn)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun maxHeightOfTriangle(red: Int, blue: Int): Int {
        fun height(x: Int, y: Int): Int {
            val a = (2 * sqrt(x.toDouble())).toInt() - 1
            val b = sqrt(4.0 * y + 1).toInt() - 1
            return minOf(a, b) + if (a != b) 1 else 0
        }
        return maxOf(height(red, blue), height(blue, red))
    }
}
