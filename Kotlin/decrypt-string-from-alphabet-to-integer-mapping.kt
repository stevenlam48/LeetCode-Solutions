package decryptstringfromalphabettointegermapping

// Time:  O(n)
// Space: O(1)
class Solution {
    fun freqAlphabets(s: String): String {
        val result = StringBuilder()
        var i = 0
        while (i < s.length) {
            if (i + 2 < s.length && s[i + 2] == '#') {
                result.append(alpha(s.substring(i, i + 2)))
                i += 3
            } else {
                result.append(alpha(s.substring(i, i + 1)))
                ++i
            }
        }
        return result.toString()
    }

    private fun alpha(s: String): Char = ('a'.code + s.toInt() - 1).toChar()
}
