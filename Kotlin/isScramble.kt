package isScramble

// Time Complexity: O(n^4),  due to enumeration of n, i, j, k in (f[n][i][j] and k)
// Space Complexity: O(n^3), due to hash of f[n][i][j]

class Solution {
    private val hash = HashMap<Triple<Int, Int, Int>, Boolean>()

    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        return isScramble(s1.length, s1, s2, 0, 0)
    }

    private fun isScramble(n: Int, s1: String, s2: String, i1: Int, i2: Int): Boolean {
        val key = Triple(n, i1, i2)
        hash[key]?.let { return it }

        if (n == 1) return s1[i1] == s2[i2]

        var value1 = 0
        var value2 = 0
        for (k in 0 until n) {
            value1 += s1[i1 + k] - 'a'
            value2 += s2[i2 + k] - 'a'
        }
        if (value1 != value2) {
            hash[key] = false
            return false
        }

        for (k in 1 until n) {
            if ((isScramble(k, s1, s2, i1, i2) &&
                    isScramble(n - k, s1, s2, i1 + k, i2 + k)) ||
                (isScramble(k, s1, s2, i1, i2 + n - k) &&
                    isScramble(n - k, s1, s2, i1 + k, i2))
            ) {
                hash[key] = true
                return true
            }
        }

        hash[key] = false
        return false
    }
}
