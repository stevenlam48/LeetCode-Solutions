package numberofvalidwordsinasentence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countValidWords(sentence: String): Int {
        var result = 0
        var token = 0
        var hyphen = 0
        val n = sentence.length
        for (i in 0..n) {
            if (i == n || sentence[i] == ' ') {
                if (token == 1) {
                    ++result
                }
                token = 0
                hyphen = 0
                continue
            }
            val c = sentence[i]
            if (c.isDigit() ||
                (c in "!.," && !(i == n - 1 || sentence[i + 1] == ' ')) ||
                (c == '-' && !(hyphen == 0 && 0 < i && i < n && sentence[i - 1].isLetter() && sentence[i + 1].isLetter()))
            ) {
                token = -1
                continue
            }
            if (token == 0) {
                token = 1
            }
            if (c == '-') {
                hyphen = 1
            }
        }
        return result
    }
}
