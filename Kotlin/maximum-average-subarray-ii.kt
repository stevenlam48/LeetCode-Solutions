package maximumaveragesubarrayii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var left = nums.min().toDouble()
        var delta = Double.MAX_VALUE
        while (delta > 1e-5) {
            delta = getDelta(left, nums, k)
            left += delta
        }
        return left
    }

    private fun getDelta(avg: Double, nums: IntArray, k: Int): Double {
        val accu = DoubleArray(nums.size + 1)
        var minValPos = -1
        var delta = 0.0
        for (i in nums.indices) {
            accu[i + 1] = nums[i] + accu[i] - avg
            if (i >= k - 1) {
                if (minValPos == -1 || accu[i - k + 1] < accu[minValPos]) {
                    minValPos = i - k + 1
                }
                if (accu[i + 1] - accu[minValPos] >= 0) {
                    delta = maxOf(delta, (accu[i + 1] - accu[minValPos]) / (i + 1 - minValPos))
                }
            }
        }
        return delta
    }
}
