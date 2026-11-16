package maximumswap
// Time:  O(logn), logn is the length of the number string
// Space: O(logn)

class Solution {
    fun maximumSwap(num: Int): Int {
        val digits = num.toString().toCharArray()
        var left = 0
        var right = 0
        var maxIdx = digits.size - 1
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i
            } else if (digits[maxIdx] > digits[i]) {
                left = i
                right = maxIdx
            }
        }
        val t = digits[left]
        digits[left] = digits[right]
        digits[right] = t
        return String(digits).toInt()
    }
}
