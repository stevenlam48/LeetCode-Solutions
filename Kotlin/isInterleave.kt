package isInterleave

// Time Complexity: O(m * n)
// Space Complexity: O(m + n)

class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false

        if (s1.length < s2.length) return isInterleave(s2, s1, s3)

        val f = BooleanArray(s2.length + 1) { true }

        for (j in 1..s2.length) {
            f[j] = f[j - 1] && s2[j - 1] == s3[j - 1]
        }

        for (i in 1..s1.length) {
            f[0] = f[0] && s1[i - 1] == s3[i - 1]
            for (j in 1..s2.length) {
                f[j] = (f[j] && s1[i - 1] == s3[i + j - 1]) ||
                    (f[j - 1] && s2[j - 1] == s3[i + j - 1])
            }
        }

        return f[s2.length]
    }
}
