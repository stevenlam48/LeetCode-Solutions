package minimumgardenperimetertocollectenoughapples

import kotlin.math.ceil
import kotlin.math.pow

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minimumPerimeter(neededApples: Long): Long {
        val a = 4.0
        val b = 6.0
        val c = 2.0
        val d = -neededApples.toDouble()
        val p = (3 * a * c - b.pow(2)) / (3 * a.pow(2))
        val q = (2 * b.pow(3) - 9 * a * b * c + 27 * a.pow(2) * d) / (27 * a.pow(3))
        val x = (-q / 2 + ((q / 2).pow(2) + (p / 3).pow(3)).pow(0.5)).pow(1.0 / 3) +
                (-q / 2 - ((q / 2).pow(2) + (p / 3).pow(3)).pow(0.5)).pow(1.0 / 3)
        return 8 * ceil(x - b / (3 * a)).toLong()
    }
}
