package findxvalueofarrayi

// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun resultArray(nums: IntArray, k: Int): LongArray {
        val result = LongArray(k)
        var dp = LongArray(k)
        for (x in nums) {
            val newDp = LongArray(k)
            ++newDp[x % k]
            for (i in dp.indices) {
                newDp[(i.toLong() * x % k).toInt()] += dp[i]
            }
            for (i in newDp.indices) {
                result[i] += newDp[i]
            }
            dp = newDp
        }
        return result
    }
}
