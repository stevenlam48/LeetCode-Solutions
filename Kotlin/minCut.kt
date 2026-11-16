package minCut

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)

class Solution {
    fun minCut(s: String): Int {
        val n = s.length
        val p = Array(n) { BooleanArray(n) }
        val f = IntArray(n + 1)
        for (i in 0..n) {
            f[i] = n - 1 - i
        }
        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                if (s[i] == s[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true
                    f[i] = minOf(f[i], f[j + 1] + 1)
                }
            }
        }
        return f[0]
    }
}
