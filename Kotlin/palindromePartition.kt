package palindromePartition

// Time Complexity: average: O(n^2), worst: O(n^2 * 2^n)
// Space Complexity: average: O(1), worst: O(2^n)

class Solution {
    fun partition(s: String): List<List<String>> {
        val n = s.length
        val p = Array(n) { BooleanArray(n) }

        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                p[i][j] = s[i] == s[j] && (j - i < 2 || p[i + 1][j - 1])
            }
        }

        val subPalins = Array(n) { mutableListOf<MutableList<String>>() }
        for (i in n - 1 downTo 0) {
            for (j in i until n) {
                if (p[i][j]) {
                    val palindrome = s.substring(i, j + 1)
                    if (j + 1 < n) {
                        for (v in subPalins[j + 1]) {
                            val nv = mutableListOf(palindrome)
                            nv.addAll(v)
                            subPalins[i].add(nv)
                        }
                    } else {
                        subPalins[i].add(mutableListOf(palindrome))
                    }
                }
            }
        }

        return subPalins[0]
    }
}
