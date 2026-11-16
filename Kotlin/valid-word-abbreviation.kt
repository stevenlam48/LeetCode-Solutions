package validwordabbreviation
// Time:  O(n)
// Space: O(1)

class Solution {
    fun validWordAbbreviation(word: String, abbr: String): Boolean {
        var i = 0
        var digit = 0
        for (c in abbr) {
            if (c.isDigit()) {
                if (digit == 0 && c == '0') {
                    return false
                }
                digit *= 10
                digit += c - '0'
            } else {
                if (digit != 0) {
                    i += digit
                    digit = 0
                }
                if (i >= word.length || word[i++] != c) {
                    return false
                }
            }
        }
        if (digit != 0) {
            i += digit
        }
        return i == word.length
    }
}
