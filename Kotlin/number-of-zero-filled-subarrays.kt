package numberofzerofilledsubarrays

// Time:  O(n)
// Space: O(1)

class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var prev = -1
        for (i in nums.indices) {
            if (nums[i] != 0) {
                prev = i
                continue
            }
            result += i - prev
        }
        return result
    }
}
