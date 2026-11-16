package combinationsumiv

// Time:  O(nlogn + n * t), t is the value of target.
// Space: O(t)


class Solution {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1
        nums.sort()

        for (i in 1..target) {
            var j = 0
            while (j < nums.size && nums[j] <= i) {
                dp[i] += dp[i - nums[j]]
                ++j
            }
        }

        return dp[target]
    }
}
