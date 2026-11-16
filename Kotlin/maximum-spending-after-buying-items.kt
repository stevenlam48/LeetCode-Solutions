package maximumspendingafterbuyingitems

// Time:  O(m * n * logm)
// Space: O(m)

class Solution {
    fun maxSpending(values: Array<IntArray>): Long {
        val m = values.size
        val n = values[0].size
        val idx = IntArray(m) { n - 1 }
        val minHeap = java.util.PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
        for (i in 0 until m) {
            minHeap.add(intArrayOf(values[i][idx[i]], i))
        }
        var result = 0L
        var d = 1L
        while (d <= m.toLong() * n) {
            val top = minHeap.poll()
            val x = top[0]
            val i = top[1]
            result += x * d
            idx[i]--
            if (idx[i] >= 0) {
                minHeap.add(intArrayOf(values[i][idx[i]], i))
            }
            d++
        }
        return result
    }
}
