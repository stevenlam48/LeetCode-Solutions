package findthepowerofksizesubarraysi
// Time:  O(n)
// Space: O(1)

class Solution {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1) { -1 }
        var left = 0
        for (right in nums.indices) {
            if (nums[right] - nums[left] != right - left) {
                left = right
            }
            if (right - left + 1 == k) {
                result[left++] = nums[right]
            }
        }
        return result
    }
}
