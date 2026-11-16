package optimaldivision

// Time:  O(n)
// Space: O(1)

class Solution {
    fun optimalDivision(nums: IntArray): String {
        if (nums.size == 1) {
            return nums[0].toString()
        }
        if (nums.size == 2) {
            return nums[0].toString() + "/" + nums[1].toString()
        }
        val result = StringBuilder()
        result.append(nums[0]).append("/(").append(nums[1])
        for (i in 2 until nums.size) {
            result.append("/").append(nums[i])
        }
        result.append(')')
        return result.toString()
    }
}
