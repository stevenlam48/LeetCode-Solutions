package maximumnumberofoperationswiththesamescorei
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxOperations(nums: IntArray): Int {
        var result = 1
        val target = nums[0] + nums[1]
        for (i in 2 until nums.size - 1 step 2) {
            if (nums[i] + nums[i + 1] != target) {
                break
            }
            ++result
        }
        return result
    }
}
