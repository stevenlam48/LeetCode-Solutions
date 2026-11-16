package oncetwice

// Time:  O(n)
// Space: O(1)

class Solution {
    fun onceTwice(nums: IntArray): IntArray {
        var dp = IntArray(3)
        var newDp = IntArray(3)
        dp[0] = 0.inv()
        for (x in nums) {
            for (i in 0..2) {
                newDp[i] = (x and dp[if (i - 1 >= 0) i - 1 else 2]) or (x.inv() and dp[i])
            }
            val tmp = dp
            dp = newDp
            newDp = tmp
        }
        var dp2 = IntArray(3)
        var newDp2 = IntArray(3)
        dp2[0] = 0.inv()
        for (x in nums) {
            if ((x.inv() and dp[1]) != 0 || (x and dp[2]) != 0) {
                continue
            }
            for (i in 0..2) {
                newDp2[i] = (x and dp2[if (i - 1 >= 0) i - 1 else 2]) or (x.inv() and dp2[i])
            }
            val tmp = dp2
            dp2 = newDp2
            newDp2 = tmp
        }
        return intArrayOf(dp2[1], (dp2[1] xor dp[1]) or dp[2])
    }
}
