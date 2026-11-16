package minimumabsolutedifferencebetweentwovalues

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minAbsoluteDifference(nums: IntArray): Int {
        var result = Int.MAX_VALUE
        var i = -1
        var j = -1
        for (k in nums.indices) {
            if (nums[k] == 0) {
                continue
            }
            if (nums[k] == 1) {
                i = k
            } else {
                j = k
            }
            if (i != -1 && j != -1) {
                result = minOf(result, Math.abs(i - j))
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
