package numberofpeopleawareofasecret

// Time:  O(n)
// Space: O(f)

class Solution {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        val mod = 1_000_000_007
        val dp = IntArray(forget)
        dp[0] = 1
        for (i in 1 until n) {
            val previous = if (i - 1 != 0) dp[(i - 1) % forget] else 0
            val delayed = dp[((i - delay) % forget + forget) % forget]
            dp[i % forget] = ((previous - dp[i % forget] + delayed) % mod + mod) % mod
        }
        return dp.fold(0) { total, value -> (total + value) % mod }
    }
}
