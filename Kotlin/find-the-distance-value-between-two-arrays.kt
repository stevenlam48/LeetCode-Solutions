package findthedistancevaluebetweentwoarrays

// Time:  O((n + m) * logm)
// Space: O(1)
class Solution {
    fun findTheDistanceValue(arr1: IntArray, arr2: IntArray, d: Int): Int {
        arr2.sort()
        var result = 0
        for (x in arr1) {
            val j = lowerBound(arr2, x)
            val left = if (j - 1 >= 0) arr2[j - 1] else Int.MIN_VALUE
            val right = if (j < arr2.size) arr2[j] else Int.MAX_VALUE
            if (left + d < x && x < right - d) {
                ++result
            }
        }
        return result
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
