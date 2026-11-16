package laststoneweightii

// Time:  O(2^n)
// Space: O(2^n)

import kotlin.math.abs

class Solution {
    fun lastStoneWeightII(stones: IntArray): Int {
        var dp = mutableSetOf(0)
        for (stone in stones) {
            val tmp = dp.toMutableSet()
            for (i in dp) {
                tmp.add(i + stone)
            }
            dp = tmp
        }
        val sum = stones.sum()
        var result = Int.MAX_VALUE
        for (i in dp) {
            result = minOf(result, abs(i - (sum - i)))
        }
        return result
    }
}
