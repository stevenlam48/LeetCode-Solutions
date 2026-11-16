package uniquemiddleelement

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isMiddleElementUnique(nums: IntArray): Boolean {
        return nums.count { it == nums[nums.size / 2] } == 1
    }
}
