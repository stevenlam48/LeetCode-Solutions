package countsubarraysoflengththreewithacondition

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun countSubarrays(nums: IntArray): Int {
        var result = 0
        for (i in 1 until nums.size - 1) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                ++result
            }
        }
        return result
    }
}
