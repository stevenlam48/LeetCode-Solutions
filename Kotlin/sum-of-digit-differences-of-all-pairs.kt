package sumofdigitdifferencesofallpairs

// Time:  O(nlogr)
// Space: O(10 * logr)

// prefix sum
class Solution {
    fun sumDigitDifferences(nums: IntArray): Long {
        var l = 0
        var base = 1L
        while (base <= nums[0]) {
            base *= 10
            ++l
        }
        val cnts = Array(l) { IntArray(10) }
        for (x0 in nums) {
            var x = x0
            for (i in 0 until l) {
                ++cnts[i][x % 10]
                x /= 10
            }
        }
        var result = 0L
        for (cnt in cnts) {
            for (c in cnt) {
                result += c.toLong() * (nums.size - c)
            }
        }
        return result / 2
    }
}
