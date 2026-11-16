package minimumsubsequenceinnonincreasingorder

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minSubsequence(nums: IntArray): IntArray {
        val total = nums.sum()
        var curr = 0
        nums.sortDescending()
        var result = 0
        for (i in nums.indices) {
            curr += nums[i]
            if (curr > total - curr) {
                result = i + 1
                break
            }
        }
        return nums.copyOfRange(0, result)
    }
}
