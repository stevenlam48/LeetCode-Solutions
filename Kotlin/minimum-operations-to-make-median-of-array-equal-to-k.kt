package minimumoperationstomakemedianofarrayequaltok

// Time:  O(n)
// Space: O(1)

// quick select, greedy
class Solution {
    fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
        nums.sort()
        var result = 0L
        val mid = nums.size / 2
        for (i in 0..mid) {
            result += maxOf(nums[i] - k, 0).toLong()
        }
        for (i in mid until nums.size) {
            result += maxOf(k - nums[i], 0).toLong()
        }
        return result
    }
}
