package findkthsmallestpairdistance
// Time:  O(nlogn + nlogw), n = len(nums), w = max(nums) - min(nums)
// Space: O(1)

class Solution {
    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums[nums.lastIndex] - nums[0] + 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (possible(mid, nums, k)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun possible(guess: Int, nums: IntArray, k: Int): Boolean {
        var count = 0
        var left = 0
        for (right in nums.indices) {
            while (nums[right] - nums[left] > guess) {
                ++left
            }
            count += right - left
        }
        return count >= k
    }
}
