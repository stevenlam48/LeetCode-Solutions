package maximumdifferencebetweenevenandoddfrequencyii

// Time:  O(d^2 * n)
// Space: O(n)

class Solution {
    fun maxDifference(s: String, k: Int): Int {
        fun difference(x: Char, y: Char): Int {
            val prefix1 = IntArray(s.length + 1)
            val prefix2 = IntArray(s.length + 1)
            val prefix = IntArray(s.length + 1)
            for (i in s.indices) {
                prefix1[i + 1] = prefix1[i] + if (s[i] == x) 1 else 0
                prefix2[i + 1] = prefix2[i] + if (s[i] == y) 1 else 0
                prefix[i + 1] = prefix[i] + (if (s[i] == x) 1 else 0) - (if (s[i] == y) 1 else 0)
            }
            var result = Int.MIN_VALUE
            val mn = Array(2) { IntArray(2) { Int.MAX_VALUE } }
            var left = 0
            for (right in k - 1 until s.length) {
                while (
                    k <= right - left + 1 &&
                    prefix1[right + 1] - prefix1[left] != 0 &&
                    prefix2[right + 1] - prefix2[left] != 0
                ) {
                    val i = prefix1[left] % 2
                    val j = prefix2[left] % 2
                    mn[i][j] = minOf(mn[i][j], prefix[left])
                    ++left
                }
                val i = prefix1[right + 1] % 2
                val j = prefix2[right + 1] % 2
                if (mn[i xor 1][j] != Int.MAX_VALUE) {
                    result = maxOf(result, prefix[right + 1] - mn[i xor 1][j])
                }
            }
            return result
        }

        val lookup = s.toHashSet()
        var result = Int.MIN_VALUE
        for (x in lookup) {
            for (y in lookup) {
                if (x != y) {
                    result = maxOf(result, difference(x, y))
                }
            }
        }
        return result
    }
}
