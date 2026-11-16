package maximumstrengthofkdisjointsubarrays

// Time:  O(k * n)
// Space: O(n)

class Solution {
    fun maximumStrength(nums: IntArray, k: Int): Long {
        val negInf = Long.MIN_VALUE
        var dp = LongArray(nums.size + 1)
        for (i in 0 until k) {
            val newDp = LongArray(nums.size + 1) { negInf }
            for (j in nums.indices) {
                val mx = maxOf(newDp[j], dp[j])
                if (mx != negInf) {
                    newDp[j + 1] = mx + nums[j].toLong() * (k - i) * (if (i % 2 == 0) 1 else -1)
                }
            }
            dp = newDp
        }
        return dp.max()
    }
}
