package minimumincompatibility
// Time:  O(max(n * 2^n, 3^n))
// Space: O(2^n)

class Solution {
    fun minimumIncompatibility(nums: IntArray, k: Int): Int {
        val candidates = findCandidates(nums, k)
        val total = (1 shl nums.size) - 1
        val dp = IntArray(total + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (mask in 0..total) {
            if (Integer.bitCount(mask) % (nums.size / k) != 0) {
                continue
            }
            var submask = mask
            while (submask != 0) {
                if (candidates[submask] != Int.MAX_VALUE && dp[mask - submask] != Int.MAX_VALUE) {
                    dp[mask] = minOf(dp[mask], dp[mask - submask] + candidates[submask])
                }
                submask = (submask - 1) and mask
            }
        }
        return if (dp[total] != Int.MAX_VALUE) dp[total] else -1
    }

    private fun findCandidates(nums: IntArray, k: Int): IntArray {
        val total = (1 shl nums.size) - 1
        val result = IntArray(total + 1) { Int.MAX_VALUE }
        for (mask in 0..total) {
            if (Integer.bitCount(mask) != nums.size / k) {
                continue
            }
            var lookup = 0
            var mx = 0
            var mn = Int.MAX_VALUE
            var duplicated = false
            for (i in nums.indices) {
                if ((mask and (1 shl i)) == 0) {
                    continue
                }
                if ((lookup and (1 shl nums[i])) != 0) {
                    duplicated = true
                    break
                }
                lookup = lookup or (1 shl nums[i])
                mx = maxOf(mx, nums[i])
                mn = minOf(mn, nums[i])
            }
            if (duplicated) {
                continue
            }
            result[mask] = mx - mn
        }
        return result
    }
}
