package maximumpulsevalueafteronesubarrayrotation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxValue(nums: IntArray): Long {
        var prefix = 0L
        var mn = 0L
        val lookup = longArrayOf(Long.MIN_VALUE, 0L)
        for ((i, x) in nums.withIndex()) {
            prefix += if (i % 2 == 0) x.toLong() else -x.toLong()
            if (lookup[i % 2] != Long.MIN_VALUE) {
                mn = minOf(mn, prefix - lookup[i % 2])
            }
            lookup[i % 2] = maxOf(lookup[i % 2], prefix)
        }
        return prefix - 2 * mn
    }
}
