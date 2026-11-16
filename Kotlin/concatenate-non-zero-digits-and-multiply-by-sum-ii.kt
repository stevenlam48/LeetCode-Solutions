package concatenatenonzerodigitsandmultiplybysumii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007
        val pow10 = IntArray(s.length + 1)
        pow10[0] = 1
        val idx = IntArray(s.length + 1)
        val x = IntArray(s.length + 1)
        val total = IntArray(s.length + 1)
        for (i in s.indices) {
            val d = s[i] - '0'
            pow10[i + 1] = (pow10[i] * 10L % mod).toInt()
            idx[i + 1] = idx[i] + if (d != 0) 1 else 0
            x[i + 1] = if (d != 0) ((x[i] * 10L + d) % mod).toInt() else x[i]
            total[i + 1] = total[i] + d
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val l = queries[i][0]
            val r = queries[i][1]
            val concatenated = ((x[r + 1] - x[l].toLong() * pow10[idx[r + 1] - idx[l]]) % mod + mod) % mod
            result[i] = (concatenated * (total[r + 1] - total[l]) % mod).toInt()
        }
        return result
    }
}
