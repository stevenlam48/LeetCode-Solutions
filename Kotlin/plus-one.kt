package plusone
// Time:  O(n)
// Space: O(1)

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] == 9) {
                digits[i] = 0
            } else {
                ++digits[i]
                return digits
            }
        }
        digits[0] = 1
        val result = IntArray(digits.size + 1)
        result[0] = 1
        return result
    }
}
