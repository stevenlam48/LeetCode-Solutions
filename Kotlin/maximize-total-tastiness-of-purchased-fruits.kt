package maximizetotaltastinessofpurchasedfruits

// Time:  O(n * a * c), n = len(price), a = maxAmount, c = maxCoupons
// Space: O(a * c)

class Solution {
    fun maxTastiness(price: IntArray, tastiness: IntArray, maxAmount: Int, maxCoupons: Int): Int {
        val dp = Array(maxAmount + 1) { IntArray(maxCoupons + 1) }
        for (k in price.indices) {
            for (i in maxAmount downTo price[k] / 2) {
                for (j in maxCoupons downTo 0) {
                    if (i - price[k] >= 0) {
                        dp[i][j] = maxOf(dp[i][j], tastiness[k] + dp[i - price[k]][j])
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] = maxOf(dp[i][j], tastiness[k] + dp[i - price[k] / 2][j - 1])
                    }
                }
            }
        }
        return dp[maxAmount][maxCoupons]
    }
}
