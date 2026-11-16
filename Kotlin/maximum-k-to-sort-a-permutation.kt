package maximumktosortapermutation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortPermutation(nums: IntArray): Int {
        var result = -1
        for (i in nums.indices) {
            if (nums[i] == i) {
                continue
            }
            result = if (result != -1) result and i else i
        }
        return if (result != -1) result else 0
    }
}
