package countspecialsubsequences

// Time:  O(n^2)
// Space: O(n^2)

// freq table
class Solution {
    fun numberOfSubsequences(nums: IntArray): Long {
        var result = 0L
        val cnt = HashMap<Double, Int>()
        var r = 4
        while (r + 2 < nums.size) {
            val q = r - 2
            for (p in 0..q - 2) {
                val key = nums[p].toDouble() / nums[q]
                cnt[key] = (cnt[key] ?: 0) + 1
            }
            for (s in r + 2 until nums.size) {
                result += cnt[nums[s].toDouble() / nums[r]] ?: 0
            }
            ++r
        }
        return result
    }
}
