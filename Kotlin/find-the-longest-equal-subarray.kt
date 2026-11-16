package findthelongestequalsubarray
// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestEqualSubarray(nums: IntArray, k: Int): Int {
        var result = 0
        var left = 0
        val cnt = HashMap<Int, Int>()
        for (right in nums.indices) {
            val count = (cnt[nums[right]] ?: 0) + 1
            cnt[nums[right]] = count
            result = maxOf(result, count)
            if (right - left + 1 > result + k) {
                cnt[nums[left]] = cnt[nums[left]]!! - 1
                ++left
            }
        }
        return result
    }
}
