package sqrtx

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) {
            return x
        }

        var left = 1
        var right = x / 2
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid > x / mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return left - 1
    }
}
