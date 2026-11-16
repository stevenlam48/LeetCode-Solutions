package stringtointegeratoi
// Time:  O(n)
// Space: O(1)

class Solution {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }
        var answer = 0
        var sign = 1
        var i = 0
        while (i < str.length && (str[i] == ' ' || str[i] == '\t')) {
            ++i
        }
        if (i == str.length) {
            return 0
        }
        if (str[i] == '+') {
            ++i
        } else if (str[i] == '-') {
            sign = -1
            ++i
        }
        while (i < str.length && str[i].isDigit()) {
            val digit = str[i] - '0'
            if (answer > (Int.MAX_VALUE - digit) / 10) {
                return if (sign > 0) Int.MAX_VALUE else Int.MIN_VALUE
            }
            answer *= 10
            answer += digit
            ++i
        }
        return answer * sign
    }
}
