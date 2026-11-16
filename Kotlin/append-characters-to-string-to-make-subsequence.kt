package appendcharacterstostringtomakesubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun appendCharacters(s: String, t: String): Int {
        var i = 0
        var j = 0
        while (j < t.length) {
            while (i <= s.length) {
                if (i == s.length) {
                    return t.length - j
                }
                if (s[i] == t[j]) {
                    ++i
                    break
                }
                ++i
            }
            ++j
        }
        return 0
    }
}
