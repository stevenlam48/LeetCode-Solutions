package findthemaximumlengthofvalidsubsequenceii
// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in 0 until k) {
            val dp = IntArray(k)
            for (x in nums) {
                dp[x % k] = dp[((i - x) % k + k) % k] + 1
            }
            result = maxOf(result, dp.maxOrNull()!!)
        }
        return result
    }
}
