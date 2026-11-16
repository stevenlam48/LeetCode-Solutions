package fairdistributionofcookies

// Time:  O(k * 3^n)
// Space: O(2^n)

class Solution {
    fun distributeCookies(cookies: IntArray, k: Int): Int {
        val total = IntArray(1 shl cookies.size)
        for (mask in 0 until (1 shl cookies.size)) {
            for (i in cookies.indices) {
                if (mask and (1 shl i) != 0) {
                    total[mask] += cookies[i]
                }
            }
        }
        val dp = Array(2) { IntArray(1 shl cookies.size) { Int.MAX_VALUE } }
        dp[0][0] = 0
        for (i in 0 until k) {
            for (mask in 0 until (1 shl cookies.size)) {
                var submask = mask
                while (submask != 0) {
                    dp[(i + 1) % 2][mask] = minOf(
                        dp[(i + 1) % 2][mask],
                        maxOf(total[submask], dp[i % 2][mask xor submask])
                    )
                    submask = (submask - 1) and mask
                }
            }
        }
        return dp[k % 2].last()
    }
}
