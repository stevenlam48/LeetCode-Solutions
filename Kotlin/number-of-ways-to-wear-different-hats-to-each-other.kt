package numberofwaystoweardifferenthatstoeachother

// Time:  O(h * 2^n)
// Space: O(2^n)

class Solution {
    fun numberWays(hats: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val hatSize = 40
        val hatToPeople = Array(hatSize) { mutableListOf<Int>() }
        for (i in hats.indices) {
            for (hat in hats[i]) {
                hatToPeople[hat - 1].add(i)
            }
        }
        val dp = IntArray(1 shl hats.size)
        dp[0] = 1
        for (people in hatToPeople) {
            for (mask in dp.lastIndex downTo 0) {
                for (p in people) {
                    if (mask and (1 shl p) != 0) {
                        continue
                    }
                    val next = mask or (1 shl p)
                    dp[next] = (dp[next] + dp[mask]) % mod
                }
            }
        }
        return dp[dp.lastIndex]
    }
}
