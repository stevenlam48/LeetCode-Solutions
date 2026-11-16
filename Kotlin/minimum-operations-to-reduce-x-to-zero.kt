package minimumoperationstoreducextozero

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        var target = 0
        for (v in nums) {
            target += v
        }
        target -= x
        var result = -1
        var curr = 0
        var left = 0
        for (right in nums.indices) {
            curr += nums[right]
            while (left < nums.size && curr > target) {
                curr -= nums[left]
                ++left
            }
            if (curr == target) {
                result = maxOf(result, right - left + 1)
            }
        }
        return if (result != -1) nums.size - result else -1
    }
}
