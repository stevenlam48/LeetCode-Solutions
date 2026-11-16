package jumpgamevii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val dp = BooleanArray(s.length)
        dp[0] = true
        var cnt = 0
        for (i in 1 until s.length) {
            if (i >= minJump) {
                cnt += if (dp[i - minJump]) 1 else 0
            }
            if (i > maxJump) {
                cnt -= if (dp[i - maxJump - 1]) 1 else 0
            }
            dp[i] = cnt > 0 && s[i] == '0'
        }
        return dp.last()
    }
}
