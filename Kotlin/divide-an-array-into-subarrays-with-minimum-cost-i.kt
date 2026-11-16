package divideanarrayintosubarrayswithminimumcosti
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumCost(nums: IntArray): Int {
        java.util.Arrays.sort(nums, 1, nums.size)
        return nums[0] + nums[1] + nums[2]
    }
}
