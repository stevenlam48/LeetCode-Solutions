package maximumscoreofagoodsubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumScore(nums: IntArray, k: Int): Int {
        var result = nums[k]
        var curr = nums[k]
        var left = k
        var right = k
        while (left - 1 >= 0 || right + 1 < nums.size) {
            val l = if (left - 1 >= 0) nums[left - 1] else 0
            val r = if (right + 1 < nums.size) nums[right + 1] else 0
            if (l < r) {
                ++right
            } else {
                --left
            }
            curr = minOf(curr, nums[left], nums[right])
            result = maxOf(result, curr * (right - left + 1))
        }
        return result
    }
}
