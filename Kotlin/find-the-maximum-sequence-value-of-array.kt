package findthemaximumsequencevalueofarray

// Time:  O(n * r + r^2)
// Space: O(r)

// bitmasks, prefix sum, dp
class Solution {
    fun maxValue(nums: IntArray, k: Int): Int {
        val INF = Int.MAX_VALUE
        val MAX_MASK = 127

        fun isSubmask(a: Int, b: Int): Boolean = (a or b) == b

        fun compute(d: Int, npos: Int): IntArray {
            val result = IntArray(MAX_MASK + 1) { npos }
            val dp = IntArray(MAX_MASK + 1) { INF }
            val cnt = IntArray(MAX_MASK + 1)
            val begin = if (d == 1) 0 else nums.size - 1
            val end = if (d == 1) nums.size else -1
            var i = begin
            while (i != end) {
                dp[nums[i]] = 1
                for (mask in 0..MAX_MASK) {
                    if (isSubmask(nums[i], mask)) {
                        ++cnt[mask]
                    }
                    if (dp[mask] != INF) {
                        dp[mask or nums[i]] = minOf(dp[mask or nums[i]], dp[mask] + 1)
                    }
                }
                for (mask in 0..MAX_MASK) {
                    if (cnt[mask] >= k && dp[mask] <= k && result[mask] == npos) {
                        result[mask] = i
                    }
                }
                i += d
            }
            return result
        }

        val left = compute(1, nums.size)
        val right = compute(-1, -1)
        for (result in MAX_MASK downTo 0) {
            for (l in 1..MAX_MASK) {
                if (left[l] < right[result xor l]) {
                    return result
                }
            }
        }
        return 0
    }
}
