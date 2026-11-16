package searchinrotatedsortedarray

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if ((nums[mid] >= nums[left] && nums[left] <= target && target < nums[mid]) ||
                (nums[mid] < nums[left] && !(nums[mid] < target && target <= nums[right]))
            ) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }
}
