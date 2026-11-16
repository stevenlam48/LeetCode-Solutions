package substringxorqueries

// Time:  O(n * logr + q), r = max(a^b for a, b in queries)
// Space: O(min(n * logr, r))
class Solution {
    fun substringXorQueries(s: String, queries: Array<IntArray>): Array<IntArray> {
        val mx = queries.maxOf { it[0] xor it[1] }
        val lookup = HashMap<Int, IntArray>()
        for (i in s.indices) {
            var curr = 0
            for (j in i until s.length) {
                curr = (curr shl 1) + (s[j] - '0')
                if (curr > mx) {
                    break
                }
                if (!lookup.containsKey(curr)) {
                    lookup[curr] = intArrayOf(i, j)
                }
                if (s[i] == '0') {
                    break
                }
            }
        }
        return Array(queries.size) { i ->
            val value = queries[i][0] xor queries[i][1]
            lookup[value]?.copyOf() ?: intArrayOf(-1, -1)
        }
    }
}
