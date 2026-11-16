package firstdaywhereyouhavebeeninalltherooms

// Time:  O(n)
// Space: O(n)

class Solution {
    fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
        val MOD = 1_000_000_007
        val dp = IntArray(nextVisit.size)
        for (i in 1 until nextVisit.size) {
            dp[i] = ((dp[i - 1].toLong() + 1 + (dp[i - 1].toLong() - dp[nextVisit[i - 1]]) + 1 + MOD) % MOD).toInt()
        }
        return dp.last()
    }
}
