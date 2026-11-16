package comparesumsofbitonicparts

// Time:  O(n)
// Space: O(1)


class Solution {
    fun compareBitonicSums(nums: IntArray): Int {
        var total = 0L
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                total += nums[i]
            } else if (nums[i] > nums[i + 1]) {
                total -= nums[i + 1]
            }
        }
        return if (total > 0) 0 else if (total < 0) 1 else -1
    }
}
