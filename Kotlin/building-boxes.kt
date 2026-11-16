package buildingboxes

// Time:  O(1)
// Space: O(1)

import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    fun minimumBoxes(n: Int): Int {
        var remaining = n
        var h = (6.0 * remaining).pow(1.0 / 3).toInt()
        if (h.toLong() * (h + 1) * (h + 2) / 6 > remaining) {
            --h
        }
        remaining -= (h.toLong() * (h + 1) * (h + 2) / 6).toInt()
        val d = ceil((-1 + sqrt(1 + 8.0 * remaining)) / 2).toInt()
        return h * (h + 1) / 2 + d
    }
}
