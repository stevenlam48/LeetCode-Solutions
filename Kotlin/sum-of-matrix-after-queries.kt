package sumofmatrixafterqueries

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun matrixSumQueries(n: Int, queries: Array<IntArray>): Long {
        val lookup = Array(2) { BooleanArray(n) }
        val cnt = IntArray(2)
        var result = 0L
        for (i in queries.indices.reversed()) {
            val t = queries[i][0]
            val idx = queries[i][1]
            val v = queries[i][2]
            if (lookup[t][idx]) {
                continue
            }
            lookup[t][idx] = true
            ++cnt[t]
            result += v.toLong() * (n - cnt[t xor 1])
        }
        return result
    }
}
