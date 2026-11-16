package numberofwaystobuildhouseofcards

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun houseOfCards(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[0] = 1
        var t = 1
        while (t <= (n + 1) / 3) {
            val w = 3 * t - 1
            for (i in n downTo w) {
                dp[i] += dp[i - w]
            }
            ++t
        }
        return dp[n]
    }
}
