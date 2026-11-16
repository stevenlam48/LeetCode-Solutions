package findthesmallestdivisorgivenathreshold

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun smallestDivisor(nums: IntArray, threshold: Int): Int {
        var left = 1
        var right = nums.max()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(nums, mid, threshold)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun check(nums: IntArray, x: Int, threshold: Int): Boolean {
        var total = 0L
        for (b in nums) {
            total += (b - 1) / x + 1
        }
        return total <= threshold
    }
}
