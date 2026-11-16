package guessnumberhigherorlower

// Time:  O(logn)
// Space: O(1)

class Solution(private val guess: (Int) -> Int) {
    fun guessNumber(n: Int): Int {
        var left = 1
        var right = n
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (guess(mid) <= 0) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
