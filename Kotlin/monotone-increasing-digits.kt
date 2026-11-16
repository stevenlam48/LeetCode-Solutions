package monotoneincreasingdigits
// Time:  O(logn) = O(1)
// Space: O(logn) = O(1)

class Solution {
    fun monotoneIncreasingDigits(N: Int): Int {
        val digits = N.toString().toCharArray()
        var leftmostInvertedIdx = digits.size
        for (i in digits.size - 1 downTo 1) {
            if (digits[i - 1] > digits[i]) {
                leftmostInvertedIdx = i
                digits[i - 1]--
            }
        }
        for (i in leftmostInvertedIdx until digits.size) {
            digits[i] = '9'
        }
        return String(digits).toInt()
    }
}
