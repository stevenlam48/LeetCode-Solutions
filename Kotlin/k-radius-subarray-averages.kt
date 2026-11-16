package kradiussubarrayaverages
// Time:  O(n)
// Space: O(1)

class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val l = 2 * k + 1
        var total = 0L
        val result = IntArray(nums.size) { -1 }
        for (i in nums.indices) {
            total += nums[i]
            if (i - l >= 0) {
                total -= nums[i - l]
            }
            if (i >= l - 1) {
                result[i - k] = (total / l).toInt()
            }
        }
        return result
    }
}
