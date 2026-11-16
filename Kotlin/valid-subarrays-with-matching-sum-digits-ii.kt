package validsubarrayswithmatchingsumdigitsii

// Time:  O(nlogr)
// Space: O(n)

class Solution {
    fun countValidSubarrays(nums: IntArray, x: Int): Long {
        val n = nums.size
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        var result = 0L
        var base = 1L
        while (x * base <= prefix[n]) {
            val cnt = LongArray(10)
            var left = 0
            var right = 0
            for (r in 0 until n) {
                while (prefix[right] <= prefix[r + 1] - x * base) {
                    ++cnt[(prefix[right] % 10).toInt()]
                    ++right
                }
                while (prefix[left] <= prefix[r + 1] - (x + 1) * base) {
                    --cnt[(prefix[left] % 10).toInt()]
                    ++left
                }
                result += cnt[(((prefix[r + 1] - x) % 10 + 10) % 10).toInt()]
            }
            base *= 10
        }
        return result
    }
}
