package minDistance

// Time Complexity: O(m * n)
// Space Complexity: O(m + n)

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val w1 = word1
        val w2 = word2
        val m0 = w1.length
        val n0 = w2.length
        if (m0 < n0) {
            return minDistance(w2, w1)
        }
        val m = w1.length
        val n = w2.length
        val f = IntArray(n + 1)
        var upperLeft: Int
        for (i in 0 until n + 1) {
            f[i] = i
        }
        for (i in 1 until m + 1) {
            upperLeft = f[0]
            f[0] = i
            for (j in 1 until n + 1) {
                val upper = f[j]
                if (w1[i - 1] == w2[j - 1]) {
                    f[j] = upperLeft
                } else {
                    f[j] = 1 + minOf(upperLeft, minOf(f[j - 1], f[j]))
                }
                upperLeft = upper
            }
        }
        return f[n]
    }
}
