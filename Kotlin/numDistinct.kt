package numDistinct

// Time Complexity: O(m * n)
// Space Complexity: O(n)

class Solution {
    fun numDistinct(S: String, T: String): Int {
        val f = IntArray(T.length + 1)
        f[0] = 1
        for (i in 1..S.length) {
            for (j in T.length downTo 1) {
                f[j] += if (S[i - 1] == T[j - 1]) f[j - 1] else 0
            }
        }
        return f[T.length]
    }
}
