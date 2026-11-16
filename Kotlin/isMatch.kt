package isMatch

// Time Complexity: O(m * n) ?
// Space Complexity: O(m * n) ?

class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, p, 0, 0)
    }

    private fun isMatch(s: String, p: String, i: Int, j: Int): Boolean {
        if (j == p.length) return i == s.length

        if (j + 1 >= p.length || p[j + 1] != '*') {
            return if (i < s.length && (p[j] == s[i] || p[j] == '.')) {
                isMatch(s, p, i + 1, j + 1)
            } else {
                false
            }
        } else {
            var si = i
            while (si < s.length && (p[j] == s[si] || p[j] == '.')) {
                if (isMatch(s, p, si, j + 2)) {
                    return true
                }
                ++si
            }
            return isMatch(s, p, si, j + 2)
        }
    }
}
