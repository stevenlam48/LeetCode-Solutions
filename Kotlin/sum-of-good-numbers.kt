package sumofgoodnumbers

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun sumOfGoodNumbers(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in nums.indices) {
            if ((i - k < 0 || nums[i - k] < nums[i]) &&
                (i + k >= nums.size || nums[i + k] < nums[i])
            ) {
                result += nums[i]
            }
        }
        return result
    }
}
