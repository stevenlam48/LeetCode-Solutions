package removedigitfromnumbertomaximizeresult
// Time:  O(n)
// Space: O(1)

class Solution {
    fun removeDigit(number: String, digit: Char): String {
        var i = 0
        while (i + 1 < number.length) {
            if (digit == number[i] && number[i] < number[i + 1]) {
                break
            }
            ++i
        }
        if (i + 1 == number.length) {
            i = number.length - 1
            while (i >= 0) {
                if (number[i] == digit) {
                    break
                }
                --i
            }
        }
        return StringBuilder(number).deleteCharAt(i).toString()
    }
}
