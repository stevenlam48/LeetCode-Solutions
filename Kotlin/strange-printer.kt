package strangeprinter
// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun strangePrinter(s: String): Int {
        val lookup = Array(s.length) { IntArray(s.length) }
        return dp(s, 0, s.length - 1, lookup)
    }

    private fun dp(s: String, i: Int, j: Int, lookup: Array<IntArray>): Int {
        if (i > j) {
            return 0
        }
        if (lookup[i][j] == 0) {
            lookup[i][j] = dp(s, i, j - 1, lookup) + 1
            for (k in i until j) {
                if (s[k] == s[j]) {
                    lookup[i][j] = minOf(
                        lookup[i][j],
                        dp(s, i, k, lookup) + dp(s, k + 1, j - 1, lookup)
                    )
                }
            }
        }
        return lookup[i][j]
    }
}
