package generaterandompointinacircle

import java.util.Random
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

// Time:  O(1)
// Space: O(1)

class Solution(
    private val radius: Double,
    private val x_center: Double,
    private val y_center: Double
) {
    private val gen = Random()

    fun randPoint(): DoubleArray {
        val r = radius * sqrt(gen.nextDouble())
        val theta = (2 * Math.PI) * gen.nextDouble()
        return doubleArrayOf(
            r * cos(theta) + x_center,
            r * sin(theta) + y_center
        )
    }
}
