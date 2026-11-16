package minimumnumberofoperationstomakearraycontinuous

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        val sorted = nums.sorted().distinct()
        var l = 0
        for (i in sorted.indices) {
            if (sorted[i] <= sorted[i - l] + n - 1) {
                ++l
            }
        }
        return n - l
    }
}
