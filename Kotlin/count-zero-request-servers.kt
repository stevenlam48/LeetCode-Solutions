package countzerorequestservers

// Time:  O(nlogn + mlogm)
// Space: O(n + m)

class Solution {
    fun countServers(n: Int, logs: Array<IntArray>, x: Int, queries: IntArray): IntArray {
        logs.sortWith(compareBy<IntArray> { it[1] })

        val events = Array(queries.size) { intArrayOf(queries[it], it) }
        events.sortWith(compareBy<IntArray>({ it[0] }, { it[1] }))

        val result = IntArray(queries.size)
        val cnt = IntArray(n)
        var curr = 0
        var left = 0
        var right = 0
        for (event in events) {
            val t = event[0]
            val i = event[1]
            while (right < logs.size && logs[right][1] <= t) {
                if (cnt[logs[right][0] - 1]++ == 0) {
                    ++curr
                }
                ++right
            }
            while (left < right && logs[left][1] < t - x) {
                if (--cnt[logs[left][0] - 1] == 0) {
                    --curr
                }
                ++left
            }
            result[i] = n - curr
        }
        return result
    }
}
