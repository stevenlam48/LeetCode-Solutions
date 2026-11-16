package shortestcommonsupersequence

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val dp = Array(2) { IntArray(str2.length + 1) }
        val backtrack = Array(str1.length + 1) { arrayOfNulls<Step>(str2.length + 1) }
        for (i in str1.indices) {
            backtrack[i + 1][0] = Step(i, 0, str1[i])
        }
        for (j in str2.indices) {
            backtrack[0][j + 1] = Step(0, j, str2[j])
        }
        for (i in str1.indices) {
            for (j in str2.indices) {
                if (dp[i % 2][j + 1] > dp[(i + 1) % 2][j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j + 1]
                    backtrack[i + 1][j + 1] = Step(i, j + 1, str1[i])
                } else {
                    dp[(i + 1) % 2][j + 1] = dp[(i + 1) % 2][j]
                    backtrack[i + 1][j + 1] = Step(i + 1, j, str2[j])
                }
                if (str1[i] != str2[j]) {
                    continue
                }
                if (dp[i % 2][j] + 1 > dp[(i + 1) % 2][j + 1]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1
                    backtrack[i + 1][j + 1] = Step(i, j, str1[i])
                }
            }
        }
        var i = str1.length
        var j = str2.length
        val result = StringBuilder()
        while (i != 0 || j != 0) {
            val step = backtrack[i][j]!!
            i = step.i
            j = step.j
            result.append(step.c)
        }
        return result.reverse().toString()
    }

    private data class Step(val i: Int, val j: Int, val c: Char)
}
