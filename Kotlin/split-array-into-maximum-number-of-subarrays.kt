package splitarrayintomaximumnumberofsubarrays
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSubarrays(nums: IntArray): Int {
        var result = 0
        var curr = 0
        for (x in nums) {
            curr = if (curr != 0) curr and x else x
            if (curr == 0) {
                ++result
            }
        }
        return maxOf(result, 1)
    }
}
