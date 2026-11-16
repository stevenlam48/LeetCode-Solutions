package maximumaveragesubarrayi

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0.0
        for (i in 0 until k) {
            sum += nums[i]
        }
        var result = sum
        for (i in k until nums.size) {
            sum += nums[i] - nums[i - k]
            result = maxOf(result, sum)
        }
        return result / k
    }
}
