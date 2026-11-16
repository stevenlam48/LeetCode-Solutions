package carpooling

import java.util.TreeMap

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        val lookup = TreeMap<Int, Int>()
        for (trip in trips) {
            lookup[trip[1]] = (lookup[trip[1]] ?: 0) + trip[0]
            lookup[trip[2]] = (lookup[trip[2]] ?: 0) - trip[0]
        }
        var cap = capacity
        for (num in lookup.values) {
            cap -= num
            if (cap < 0) {
                return false
            }
        }
        return true
    }
}
