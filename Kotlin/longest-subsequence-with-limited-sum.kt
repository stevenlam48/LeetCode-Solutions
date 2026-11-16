package longestsubsequencewithlimitedsum
// Time:  O(nlogn + qlogn)
// Space: O(1)

class Solution {
    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        nums.sort()
        for (i in 0 until nums.size - 1) {
            nums[i + 1] += nums[i]
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            result[i] = upperBound(nums, queries[i])
        }
        return result
    }

    private fun upperBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val middle = left + (right - left) / 2
            if (nums[middle] <= target) {
                left = middle + 1
            } else {
                right = middle
            }
        }
        return left
    }
}
