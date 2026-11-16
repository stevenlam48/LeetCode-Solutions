package findpivotindex

// Time:  O(n)
// Space: O(1)

class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val total = nums.sum()
        var leftSum = 0
        for (i in nums.indices) {
            if (leftSum == total - leftSum - nums[i]) {
                return i
            }
            leftSum += nums[i]
        }
        return -1
    }
}
