package nonnegativeintegerswithoutconsecutiveones

// Time:  O(1)
// Space: O(1)

class Solution {
    fun findIntegers(num: Int): Int {
        val dp = IntArray(32)
        dp[0] = 1
        dp[1] = 2
        for (i in 2 until dp.size) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        var result = 0
        var prevBit = 0
        for (i in 30 downTo 0) {
            if ((num and (1 shl i)) != 0) {
                result += dp[i]
                if (prevBit == 1) {
                    --result
                    break
                }
                prevBit = 1
            } else {
                prevBit = 0
            }
        }
        return result + 1
    }
}
