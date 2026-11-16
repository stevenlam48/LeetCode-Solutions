package capacitytoshippackageswithinddays

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var left = weights.maxOrNull()!!
        var right = weights.sum()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (possible(weights, D, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun possible(weights: IntArray, D: Int, mid: Int): Boolean {
        var result = 1
        var curr = 0
        for (w in weights) {
            if (curr + w > mid) {
                ++result
                curr = 0
            }
            curr += w
        }
        return result <= D
    }
}
