package countsortedvowelstrings

// Time:  O(1)
// Space: O(1)

class Solution {
    fun countVowelStrings(n: Int): Int {
        return nCr(n + 4, 4).toInt()
    }

    private fun nCr(n: Int, r: Int): Long {
        if (n - r < r) {
            return nCr(n, n - r)
        }
        var result = 1L
        for (k in 1..r) {
            result *= (n - k + 1).toLong()
            result /= k
        }
        return result
    }
}
