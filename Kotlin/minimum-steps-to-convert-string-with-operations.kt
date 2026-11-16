package minimumstepstoconvertstringwithoperations

// Time:  O(n^2)
// Space: O(26^2)

class Solution {
    fun minOperations(word1: String, word2: String): Int {
        val n = word1.length
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until 2 * n - 1) {
            val cnt = Array(26) { IntArray(26) }
            var left = i / 2
            var right = (i + 1) / 2
            var curr = 1
            while (left >= 0 && right < n) {
                for (j in 0 until 2) {
                    val x = word1[left]
                    val y = word2[right]
                    if (x != y && (left != right || j == 0)) {
                        if (cnt[y - 'a'][x - 'a'] != 0) {
                            --cnt[y - 'a'][x - 'a']
                        } else {
                            ++cnt[x - 'a'][y - 'a']
                            ++curr
                        }
                    }
                    val temp = left
                    left = right
                    right = temp
                }
                dp[left][right] = curr
                --left
                ++right
            }
        }
        val dp2 = IntArray(n + 1) { Int.MAX_VALUE }
        dp2[0] = 0
        for (i in 0 until n) {
            val cnt = Array(26) { IntArray(26) }
            var curr = 0
            for (j in i downTo 0) {
                val x = word1[j]
                val y = word2[j]
                if (x != y) {
                    if (cnt[y - 'a'][x - 'a'] != 0) {
                        --cnt[y - 'a'][x - 'a']
                    } else {
                        ++cnt[x - 'a'][y - 'a']
                        ++curr
                    }
                }
                dp2[i + 1] = minOf(dp2[i + 1], dp2[j] + minOf(curr, dp[j][i]))
            }
        }
        return dp2[n]
    }
}
