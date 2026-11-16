package maximumfrequencyofanelementafterperformingoperationsii

// Time:  O(nlogn)
// Space: O(n)

// sort, freq table, two pointers, sliding window
class Solution {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        nums.sort()
        var result = 0
        val cnt = HashMap<Int, Int>()
        var left = 0
        var right = -1
        for (i in nums.indices) {
            while (right + 1 < nums.size && nums[right + 1] - nums[i] <= k) {
                ++right
                cnt[nums[right]] = (cnt[nums[right]] ?: 0) + 1
            }
            while (nums[i] - nums[left] > k) {
                cnt[nums[left]] = cnt[nums[left]]!! - 1
                ++left
            }
            val c = cnt[nums[i]] ?: 0
            result = maxOf(result, c + minOf((right - left + 1) - c, numOperations))
        }
        left = 0
        for (r in nums.indices) {
            while (nums[left] + k < nums[r] - k) {
                ++left
            }
            result = maxOf(result, minOf(r - left + 1, numOperations))
        }
        return result
    }
}
