package applyoperationsonarraytomaximizesumofsquares

// Time:  O(nlogr), r = max(nums)
// Space: O(logr)

class Solution {
    fun maxSum(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        val max = nums.max()
        val l = if (max != 0) Int.SIZE_BITS - max.countLeadingZeroBits() else 1
        val cnt = IntArray(l)
        for (i in 0 until l) {
            for (x in nums) {
                if (x and (1 shl i) != 0) {
                    ++cnt[i]
                }
            }
        }
        var result = 0
        for (j in 1..k) {
            var curr = 0
            for (i in 0 until l) {
                if (cnt[i] >= j) {
                    curr += 1 shl i
                }
            }
            result = ((result + curr.toLong() * curr) % mod).toInt()
        }
        return result
    }
}
