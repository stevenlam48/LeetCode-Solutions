package minimumremovalstobalancearray

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minRemoval(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        for (right in nums.indices) {
            if (nums[left].toLong() * k < nums[right]) {
                ++left
            }
        }
        return left
    }
}
