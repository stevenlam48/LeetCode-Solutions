package checkifthereisavalidpartitionforthearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun validPartition(nums: IntArray): Boolean {
        val dp = IntArray(4)
        dp[0] = 1
        for (i in nums.indices) {
            dp[(i + 1) % 4] = 0
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                dp[(i + 1) % 4] = dp[(i + 1) % 4] or dp[((i + 1) - 2) % 4]
            }
            if (i - 2 >= 0 &&
                ((nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) ||
                    (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2))
            ) {
                dp[(i + 1) % 4] = dp[(i + 1) % 4] or dp[((i + 1) - 3) % 4]
            }
        }
        return dp[nums.size % 4] != 0
    }
}
