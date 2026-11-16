package findthesumofsubsequencepowers

// Time:  O(n^2 + len(diffs) * n * k) = O(n^3 * k) at most
// Space: O(len(diffs) + n * k) = O(n^2) at most

// sort, dp, prefix sum, two pointers
class Solution {
    fun sumOfPowers(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007

        nums.sort()
        val diffs = HashSet<Int>()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                diffs.add(nums[j] - nums[i])
            }
        }
        val sortedDiffs = diffs.toIntArray()
        sortedDiffs.sortDescending()
        var result = 0L
        var prev = 0L
        for (mn in sortedDiffs) {
            val dp = Array(nums.size + 1) { LongArray(k + 1) }
            dp[0][0] = 1
            var j = 0
            for (i in nums.indices) {
                while (j < nums.size && nums[i] - nums[j] >= mn) {
                    ++j
                }
                for (l in 1..k) {
                    dp[i + 1][l] = (dp[i + 1][l] + dp[j][l - 1]) % MOD
                }
                for (l in 0..k) {
                    dp[i + 1][l] = (dp[i + 1][l] + dp[i][l]) % MOD
                }
            }
            val cnt = ((dp[nums.size][k] - prev) + MOD) % MOD
            result = (result + (mn.toLong() * cnt % MOD)) % MOD
            prev = dp[nums.size][k]
        }
        return result.toInt()
    }
}
