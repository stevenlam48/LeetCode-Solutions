package validsubarrayswithexactlyonepeak

// Time:  O(n)
// Space: O(1)

class Solution {
    fun validSubarrays(nums: IntArray, k: Int): Long {
        var result = 0L
        var left = -1L
        var l = 0L
        var right = 1L
        while (right + 1 < nums.size) {
            if (nums[(right - 1).toInt()] < nums[right.toInt()] && nums[right.toInt()] > nums[(right + 1).toInt()]) {
                val r = minOf(right - left, (k + 1).toLong())
                result += l * r
                left = right
                l = r
            }
            ++right
        }
        result += l * minOf(nums.size.toLong() - left, (k + 1).toLong())
        return result
    }
}
