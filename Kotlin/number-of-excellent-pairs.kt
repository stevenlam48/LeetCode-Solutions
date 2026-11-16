package numberofexcellentpairs

// Time:  O(n + (logn)^2) = O(n)
// Space: O(n + logn) = O(n)

// bit manipulation, freq table, combinatorics
class Solution {
    fun countExcellentPairs(nums: IntArray, k: Int): Long {
        fun bitLength(x: Int): Int = if (x != 0) 32 - Integer.numberOfLeadingZeros(x) else 1

        val mx = nums.max()
        val cnt = LongArray(bitLength(mx) + 1)
        val lookup = HashSet<Int>()
        for (x in nums) {
            if (!lookup.add(x)) {
                continue
            }
            cnt[Integer.bitCount(x)]++
        }
        var result = 0L
        for (i in 1 until cnt.size) {
            for (j in 1 until cnt.size) {
                if (i + j >= k) {
                    result += cnt[i] * cnt[j]
                }
            }
        }
        return result
    }
}
