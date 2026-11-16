package palindromePartition2

// Time Complexity: O(2^n)
// Space Complexity: O(n^2)

class Solution {
    fun partition(s: String): List<List<String>> {
        val n = s.length
        val p = Array(n) { BooleanArray(n) }
        val path = mutableListOf<String>()
        val ans = mutableListOf<MutableList<String>>()
        buildPalindromeMap(s, p)
        dfs(s, p, 0, path, ans)
        return ans
    }

    private fun buildPalindromeMap(s: String, p: Array<BooleanArray>) {
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                p[i][j] = s[i] == s[j] && (j - i < 2 || p[i + 1][j - 1])
            }
        }
    }

    private fun dfs(
        s: String,
        p: Array<BooleanArray>,
        start: Int,
        path: MutableList<String>,
        ans: MutableList<MutableList<String>>
    ) {
        if (start == s.length) {
            ans.add(path.toMutableList())
            return
        }
        for (i in start until s.length) {
            if (p[start][i]) {
                path.add(s.substring(start, i + 1))
                dfs(s, p, i + 1, path, ans)
                path.removeAt(path.size - 1)
            }
        }
    }
}
