package maximumsizesubarraysumequalsk

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        val sums = HashMap<Int, Int>()
        var curSum = 0
        var maxLen = 0
        for (i in nums.indices) {
            curSum += nums[i]
            if (curSum == k) {
                maxLen = i + 1
            } else if (sums.containsKey(curSum - k)) {
                maxLen = maxOf(maxLen, i - sums[curSum - k]!!)
            }
            if (!sums.containsKey(curSum)) {
                sums[curSum] = i
            }
        }
        return maxLen
    }
}
