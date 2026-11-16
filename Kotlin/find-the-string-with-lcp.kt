package findthestringwithlcp

// Time:  O(n^2)
// Space: O(1)

// constructive algorithms, greedy, dp
class Solution {
    fun findTheString(lcp: Array<IntArray>): String {
        val n = lcp.size
        val m = lcp[0].size
        val result = CharArray(n)
        var curr = 'a'
        for (i in 0 until n) {
            if (result[i] != '\u0000') {
                continue
            }
            if (curr > 'z') {
                return ""
            }
            for (j in i until m) {
                if (lcp[i][j] != 0) {
                    result[j] = curr
                }
            }
            ++curr
        }
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                val expected = if (result[i] == result[j]) {
                    if (i + 1 < n && j + 1 < m) lcp[i + 1][j + 1] + 1 else 1
                } else {
                    0
                }
                if (lcp[i][j] != expected) {
                    return ""
                }
            }
        }
        return String(result)
    }
}
