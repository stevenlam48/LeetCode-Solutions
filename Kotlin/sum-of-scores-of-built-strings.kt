package sumofscoresofbuiltstrings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun sumScores(s: String): Long {
        val z = zFunction(s)
        z[0] = s.length
        return z.sumOf { it.toLong() }
    }

    private fun zFunction(s: String): IntArray {
        val z = IntArray(s.length)
        var left = 0
        var right = 0
        for (i in 1 until z.size) {
            if (i <= right) {
                z[i] = minOf(right - i + 1, z[i - left])
            }
            while (i + z[i] < z.size && s[z[i]] == s[i + z[i]]) {
                ++z[i]
            }
            if (i + z[i] - 1 > right) {
                left = i
                right = i + z[i] - 1
            }
        }
        return z
    }
}
