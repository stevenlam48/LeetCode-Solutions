package partitionarraysuchthatmaximumdifferenceisk

// Time:  O(nlogn)
// Space: O(1)

// sort, greedy
class Solution {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var result = 1
        var prev = 0
        for (i in nums.indices) {
            if (nums[i] - nums[prev] <= k) {
                continue
            }
            prev = i
            ++result
        }
        return result
    }
}
