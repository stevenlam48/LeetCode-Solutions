package runningsumof1darray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        for (i in 1 until nums.size) {
            nums[i] += nums[i - 1]
        }
        return nums
    }
}
