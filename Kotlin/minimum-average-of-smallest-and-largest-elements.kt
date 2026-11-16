package minimumaverageofsmallestandlargestelements

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumAverage(nums: IntArray): Double {
        nums.sort()
        var result = Double.MAX_VALUE
        for (i in 0 until nums.size / 2) {
            result = minOf(result, (nums[i] + nums[nums.size - 1 - i]) / 2.0)
        }
        return result
    }
}
