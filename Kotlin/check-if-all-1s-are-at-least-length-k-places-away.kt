package checkifall1sareatleastlengthkplacesaway

// Time:  O(n)
// Space: O(1)

class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var prev = -k - 1
        for (i in nums.indices) {
            if (nums[i] == 0) {
                continue
            }
            if (i - prev <= k) {
                return false
            }
            prev = i
        }
        return true
    }
}
