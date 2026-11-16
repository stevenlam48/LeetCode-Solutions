package findthemaximumnumberofmarkedindices

// Time:  O(nlogn)
// Space: O(1)

// sort, greedy, two pointers
class Solution {
    fun maxNumOfMarkedIndices(nums: IntArray): Int {
        nums.sort()
        var left = 0
        for (right in (nums.size + 1) / 2 until nums.size) {
            if (nums[right] >= 2 * nums[left]) {
                ++left
            }
        }
        return left * 2
    }
}
