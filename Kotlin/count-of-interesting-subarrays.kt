package countofinterestingsubarrays

// Time:  O(n)
// Space: O(m)

// freq table, prefix sum
class Solution {
    fun countInterestingSubarrays(nums: IntArray, modulo: Int, k: Int): Long {
        val cnt = HashMap<Int, Int>()
        cnt[0] = 1
        var result = 0L
        var prefix = 0
        for (x in nums) {
            if (x % modulo == k) {
                prefix = (prefix + 1) % modulo
            }
            result += cnt[((prefix - k) % modulo + modulo) % modulo] ?: 0
            cnt[prefix] = (cnt[prefix] ?: 0) + 1
        }
        return result
    }
}
