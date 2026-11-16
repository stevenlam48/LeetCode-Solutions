package minimumswapstomovezerostoend

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumSwaps(nums: IntArray): Int {
        var result = 0
        for (i in nums.size - nums.count { it == 0 } until nums.size) {
            if (nums[i] != 0) {
                ++result
            }
        }
        return result
    }
}
