package dividearrayintoincreasingsequences
// Time:  O(n)
// Space: O(1)

class Solution {
    fun canDivideIntoSubsequences(nums: IntArray, k: Int): Boolean {
        var curr = 1
        var maxCount = 1
        for (i in 1 until nums.size) {
            curr = if (nums[i - 1] < nums[i]) 1 else curr + 1
            maxCount = maxOf(maxCount, curr)
        }
        return k * maxCount <= nums.size
    }
}
