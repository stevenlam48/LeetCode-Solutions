package continuoussubarraysum
// Time:  O(n)
// Space: O(k)

class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        var count = 0
        val lookup = hashMapOf(0 to -1)
        for (i in nums.indices) {
            count += nums[i]
            if (k != 0) {
                count %= k
            }
            if (count in lookup) {
                if (i - lookup[count]!! > 1) {
                    return true
                }
            } else {
                lookup[count] = i
            }
        }
        return false
    }
}
