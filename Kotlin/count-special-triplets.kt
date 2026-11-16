package countspecialtriplets

// Time:  O(n)
// Space: O(n)

// dp
class Solution {
    fun specialTriplets(nums: IntArray): Int {
        val MOD = 1_000_000_007

        var result = 0
        val dp = Array(2) { HashMap<Int, Int>() }
        for (x in nums) {
            if (x % 2 == 0 && dp[1].containsKey(x / 2)) {
                result = (result + dp[1][x / 2]!!) % MOD
            }
            if (dp[0].containsKey(2 * x)) {
                dp[1][x] = ((dp[1][x] ?: 0) + dp[0][2 * x]!!) % MOD
            }
            dp[0][x] = ((dp[0][x] ?: 0) + 1) % MOD
        }
        return result
    }
}
