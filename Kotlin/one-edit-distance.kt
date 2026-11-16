package oneeditdistance

// Time:  O(m + n)
// Space: O(1)

class Solution {
    fun isOneEditDistance(s: String, t: String): Boolean {
        val m = s.length
        val n = t.length
        if (m > n) {
            return isOneEditDistance(t, s)
        }
        if (n - m > 1) {
            return false
        }

        var i = 0
        val shift = n - m
        while (i < m && s[i] == t[i]) {
            ++i
        }
        if (shift == 0) {
            ++i
        }
        while (i < m && s[i] == t[i + shift]) {
            ++i
        }

        return i == m
    }
}
