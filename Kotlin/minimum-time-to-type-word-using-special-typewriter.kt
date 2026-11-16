package minimumtimetotypewordusingspecialtypewriter

// Time:  O(n)
// Space; O(1)

import kotlin.math.abs

class Solution {
    fun minTimeToType(word: String): Int {
        var result = 0
        var previous = 'a'
        for (current in word) {
            val distance = abs(current - previous)
            result += minOf(distance, 26 - distance) + 1
            previous = current
        }
        return result
    }
}
