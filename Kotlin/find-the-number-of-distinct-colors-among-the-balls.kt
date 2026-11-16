package findthenumberofdistinctcolorsamongtheballs

// Time:  O(q)
// Space: O(q)

// freq table
class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)
        val lookup = HashMap<Int, Int>()
        val cnt = HashMap<Int, Int>()
        for (i in queries.indices) {
            val x = queries[i][0]
            val y = queries[i][1]
            if (lookup.containsKey(x)) {
                val old = lookup[x]!!
                val c = cnt[old]!! - 1
                if (c == 0) {
                    cnt.remove(old)
                } else {
                    cnt[old] = c
                }
            }
            lookup[x] = y
            cnt[y] = (cnt[y] ?: 0) + 1
            result[i] = cnt.size
        }
        return result
    }
}
