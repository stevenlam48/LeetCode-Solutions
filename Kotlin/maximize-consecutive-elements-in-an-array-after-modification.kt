package maximizeconsecutiveelementsinanarrayaftermodification

// Time:  O(nlogn)
// Space: O(1)

// sort, dp
class Solution {
    fun maxSelectedElements(nums: IntArray): Int {
        nums.sort()
        var result = 1
        val dp = intArrayOf(1, 1)
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
                dp[1] = dp[0] + 1
            } else if (nums[i] == nums[i - 1] + 1) {
                ++dp[0]
                ++dp[1]
            } else if (nums[i] == nums[i - 1] + 2) {
                dp[0] = dp[1] + 1
                dp[1] = 1
            } else {
                dp[0] = 1
                dp[1] = 1
            }
            result = maxOf(result, dp[0], dp[1])
        }
        return result
    }
}
