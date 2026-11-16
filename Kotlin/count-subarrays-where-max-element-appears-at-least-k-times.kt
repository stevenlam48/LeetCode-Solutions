package countsubarrayswheremaxelementappearsatleastktimes

// Time:  O(n)
// Space: O(1)

// two pointers, sliding window
class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val mx = nums.max()
        var result = 0L
        var left = 0
        var cnt = 0
        for (right in nums.indices) {
            if (nums[right] == mx) {
                ++cnt
            }
            while (cnt == k) {
                if (nums[left] == mx) {
                    --cnt
                }
                ++left
            }
            result += left
        }
        return result
    }
}
