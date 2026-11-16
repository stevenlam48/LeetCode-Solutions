package maximumuniquesubarraysumafterdeletion

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSum(nums: IntArray): Int {
        val maximum = nums.max()
        if (maximum < 0) {
            return maximum
        }
        val lookup = nums.toHashSet()
        var result = 0
        for (x in lookup) {
            if (x > 0) {
                result += x
            }
        }
        return result
    }
}
