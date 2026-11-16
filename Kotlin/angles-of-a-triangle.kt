package anglesofatriangle

// Time:  O(1)
// Space: O(1)

import kotlin.math.acos
import kotlin.math.PI

class Solution {
    fun internalAngles(sides: IntArray): DoubleArray {
        sides.sort()
        val a = sides[0]
        val b = sides[1]
        val c = sides[2]
        return if (a + b > c) {
            doubleArrayOf(
                acos((b * b + c * c - a * a) / (2.0 * b * c)) * (180.0 / PI),
                acos((a * a + c * c - b * b) / (2.0 * a * c)) * (180.0 / PI),
                acos((a * a + b * b - c * c) / (2.0 * a * b)) * (180.0 / PI)
            )
        } else {
            DoubleArray(0)
        }
    }
}
