package numberofsameendsubstrings

// Time:  O(26 * (n + q))
// Space: O(26 * n)

// freq table, prefix sum
class Solution {
    fun sameEndSubstringCount(s: String, queries: Array<IntArray>): IntArray {
        val prefix = Array(s.length + 1) { IntArray(26) }
        for (i in s.indices) {
            prefix[i + 1].indices.forEach { prefix[i + 1][it] = prefix[i][it] }
            ++prefix[i + 1][s[i] - 'a']
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            for (j in 0 until 26) {
                val cnt = prefix[r + 1][j] - prefix[l][j]
                result[i] += (1 + cnt) * cnt / 2
            }
        }
        return result
    }
}
