package numberofalternatingxorpartitions

// Time:  O(n)
// Space: O(1)

class Solution {
    fun alternatingXOR(nums: IntArray, target1: Int, target2: Int): Int {
        val MOD = 1000000007

        val vals = intArrayOf(0, target1, target1 xor target2, target2)
        var dp = IntArray(vals.size)
        dp[0] = 1
        var prefix = 0
        for (i in 0 until nums.size - 1) {
            val newDp = dp.copyOf()
            prefix = prefix xor nums[i]
            for (j in vals.indices) {
                if (vals[j] != prefix) {
                    continue
                }
                newDp[j] = (newDp[j] + dp[((j - 1) % dp.size + dp.size) % dp.size]) % MOD
            }
            dp = newDp
        }
        prefix = prefix xor nums.last()
        var result = 0
        for (j in vals.indices) {
            if (vals[j] != prefix) {
                continue
            }
            result = (result + dp[((j - 1) % dp.size + dp.size) % dp.size]) % MOD
        }
        return result
    }
}
