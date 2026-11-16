package longestnicesubstring

// Time:  O(26 * n) = O(n)
// Space: O(26 * n) = O(n)

class Solution {
    fun longestNiceSubstring(s: String): String {
        val lookup = Array(26) { IntArray(2) }
        for (c in s) {
            lookup[c.lowercaseChar() - 'a'][if (c.isUpperCase()) 1 else 0] = 1
        }
        var result = ""
        var prev = -1
        var i = 0
        while (i <= s.length) {
            if (!(i == s.length ||
                    lookup[s[i].lowercaseChar() - 'a'][0] == 0 ||
                    lookup[s[i].lowercaseChar() - 'a'][1] == 0)) {
                ++i
                continue
            }
            if (prev == -1 && i == s.length) {
                return s
            }
            val tmp = longestNiceSubstring(s.substring(prev + 1, i))
            if (tmp.length > result.length) {
                result = tmp
            }
            prev = i
            ++i
        }
        return result
    }
}
