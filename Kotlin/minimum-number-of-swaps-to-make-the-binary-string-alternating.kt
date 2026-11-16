package minimumnumberofswapstomakethebinarystringalternating

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minSwaps(s: String): Int {
        val ones = s.count { it == '1' }
        val zeros = s.length - ones
        if (abs(ones - zeros) > 1) {
            return -1
        }
        if (ones > zeros) {
            return cost(s, 1)
        }
        if (ones < zeros) {
            return cost(s, 0)
        }
        return minOf(cost(s, 1), cost(s, 0))
    }

    private fun cost(s: String, x: Int): Int {
        var expected = x
        var diff = 0
        for (c in s) {
            if (c - '0' != expected) {
                ++diff
            }
            expected = expected xor 1
        }
        return diff / 2
    }
}
