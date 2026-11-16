package maximumtotalvalueofcoveredindices

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxTotal(nums: IntArray, s: String): Long {
        var result = 0L
        var i = 0
        while (i < nums.size) {
            if (s[i] == '0') {
                ++i
                continue
            }
            result += if (i - 1 >= 0) nums[i - 1] else 0
            var minimum = if (i - 1 >= 0) nums[i - 1] else 0
            var j = i
            while (j < nums.size && s[j] == '1') {
                result += nums[j]
                minimum = minOf(minimum, nums[j])
                ++j
            }
            result -= minimum
            i = j
        }
        return result
    }
}
