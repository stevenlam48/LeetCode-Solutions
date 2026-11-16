package happystudents

// Time:  O(n)
// Space: O(n)
class Solution {
    fun countWays(nums: IntArray): Int {
        val cnt = IntArray(nums.size + 1)
        for (x in nums) {
            ++cnt[x]
        }
        var result = 0
        var prefix = 0
        for (i in 0..nums.size) {
            if (prefix == i && cnt[i] == 0) {
                ++result
            }
            prefix += cnt[i]
        }
        return result
    }
}
