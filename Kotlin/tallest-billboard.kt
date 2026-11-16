package tallestbillboard
// Time:  O(n * 3^(n/2))
// Space: O(3^(n/2))

import kotlin.math.abs

class Solution {
    fun tallestBillboard(rods: IntArray): Int {
        val left = dp(rods, 0, rods.size / 2)
        val right = dp(rods, rods.size / 2, rods.size)
        var result = 0
        for ((difference, height) in left) {
            if (difference in right) {
                result = maxOf(result, height + right[difference]!! + difference)
            }
        }
        return result
    }

    private fun dp(rods: IntArray, start: Int, end: Int): HashMap<Int, Int> {
        val lookup = hashMapOf(0 to 0)
        for (i in start until end) {
            val tmp = HashMap(lookup)
            for ((difference, height) in tmp) {
                lookup[difference + rods[i]] = maxOf(
                    lookup.getOrDefault(difference + rods[i], 0),
                    height
                )
                val oppositeDifference = abs(difference - rods[i])
                lookup[oppositeDifference] = maxOf(
                    lookup.getOrDefault(oppositeDifference, 0),
                    height + minOf(difference, rods[i])
                )
            }
        }
        return lookup
    }
}
