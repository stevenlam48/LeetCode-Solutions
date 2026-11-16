package perfectsquares

// Time:  O(n * sqrt(n))
// Space: O(n)

class Solution {
    fun numSquares(n: Int): Int {
        while (num.size <= n) {
            var squares = Int.MAX_VALUE
            var i = 1
            while (i * i <= num.size) {
                squares = minOf(squares, num[num.size - i * i] + 1)
                ++i
            }
            num.add(squares)
        }
        return num[n]
    }

    companion object {
        private val num = mutableListOf(0)
    }
}
