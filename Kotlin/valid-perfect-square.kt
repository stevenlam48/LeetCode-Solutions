package validperfectsquare

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var left = 1
        var right = num
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid >= num / mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left == num / left && num % left == 0
    }
}
