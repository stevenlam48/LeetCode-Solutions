package maximumhammingdistances

// Time:  O(m * 2^m)
// Space: O(2^m)

class Solution {
    fun maxHammingDistances(nums: IntArray, m: Int): IntArray {
        var dp = IntArray(1 shl m) { -1 }
        for (x in nums) {
            dp[x] = 0
        }
        for (i in 0 until m) {
            val newDp = dp.copyOf()
            for (mask in 0 until (1 shl m)) {
                val distance = dp[mask xor (1 shl i)]
                if (distance != -1) {
                    newDp[mask] = maxOf(newDp[mask], distance + 1)
                }
            }
            dp = newDp
        }
        return IntArray(nums.size) { dp[nums[it]] }
    }
}
