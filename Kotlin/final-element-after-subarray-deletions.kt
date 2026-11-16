package finalelementaftersubarraydeletions

// Time:  O(1)
// Space: O(1)

class Solution {
    fun finalElement(nums: IntArray): Int {
        return maxOf(nums[0], nums.last())
    }
}
