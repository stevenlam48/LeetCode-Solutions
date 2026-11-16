package longestresilientsubarrayi

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun resilientSubarray(nums: IntArray, k: Int): Int {
        var result = 0
        var left = 0
        for (right in nums.indices) {
            if (nums[left] % k != nums[right] % k) {
                left = right
            }
            if (nums[left] * ((right - left + 1L) - 1) % k == 0L) {
                result = maxOf(result, right - left + 1)
            }
        }
        return result
    }
}
