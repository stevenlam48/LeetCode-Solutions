package lengthoflongestsubarraywithatmostkfrequency
// Time:  O(n)
// Space: o(n)

class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val cnt = HashMap<Int, Int>()
        var result = 0
        var left = 0
        for (right in nums.indices) {
            cnt[nums[right]] = (cnt[nums[right]] ?: 0) + 1
            while ((cnt[nums[right]] ?: 0) > k) {
                cnt[nums[left]] = (cnt[nums[left]] ?: 0) - 1
                ++left
            }
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
