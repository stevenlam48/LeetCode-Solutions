package countthenumberofgoodsubarrays

// Time:  O(n)
// Space: O(n)

// two pointers, sliding window
class Solution {
    fun countGood(nums: IntArray, k: Int): Long {
        var result = 0L
        var curr = 0L
        val cnt = HashMap<Int, Int>()
        var left = 0
        for (right in nums.indices) {
            val c = cnt.getOrDefault(nums[right], 0)
            curr += c
            cnt[nums[right]] = c + 1
            while (curr >= k) {
                val lc = cnt[nums[left]]!! - 1
                cnt[nums[left]] = lc
                curr -= lc
                ++left
            }
            result += left
        }
        return result
    }
}
