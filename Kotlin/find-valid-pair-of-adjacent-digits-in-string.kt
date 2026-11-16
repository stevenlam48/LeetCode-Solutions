package findvalidpairofadjacentdigitsinstring
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findValidPair(s: String): String {
        val cnt = IntArray(9)
        for (x in s) {
            ++cnt[x - '1']
        }
        for (i in 0 until s.length - 1) {
            if (s[i] != s[i + 1] && cnt[s[i] - '1'] == s[i] - '0' && cnt[s[i + 1] - '1'] == s[i + 1] - '0') {
                return s.substring(i, i + 2)
            }
        }
        return ""
    }
}
