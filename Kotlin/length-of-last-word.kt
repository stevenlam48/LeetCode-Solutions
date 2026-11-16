package lengthoflastword
// Time:  O(n)
// Space: O(1)

class Solution {
    fun lengthOfLastWord(s: String): Int {
        val isSpace = { c: Char -> c.isWhitespace() }
        var it = s.length - 1
        while (it >= 0 && isSpace(s[it])) {
            --it
        }
        var jt = it
        while (jt >= 0 && !isSpace(s[jt])) {
            --jt
        }
        return it - jt
    }
}
