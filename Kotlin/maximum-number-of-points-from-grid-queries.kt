package maximumnumberofpointsfromgridqueries

// Time:  O((m * n + q) * log(m * n))
// Space: O(m * n)

class Solution {
    fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val minHeap = java.util.PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
        minHeap.add(Triple(grid[0][0], 0, 0))
        val lookup = Array(grid.size) { BooleanArray(grid[0].size) }
        lookup[0][0] = true
        val cnt = HashMap<Int, Int>()
        var mx = 0
        while (minHeap.isNotEmpty()) {
            val (curr, i, j) = minHeap.poll()
            mx = maxOf(mx, curr)
            cnt[mx] = (cnt[mx] ?: 0) + 1
            for ((di, dj) in directions) {
                val ni = i + di
                val nj = j + dj
                if (!(0 <= ni && ni < grid.size && 0 <= nj && nj < grid[0].size && !lookup[ni][nj])) {
                    continue
                }
                lookup[ni][nj] = true
                minHeap.add(Triple(grid[ni][nj], ni, nj))
            }
        }
        val vals = cnt.keys.sorted()
        val prefix = IntArray(vals.size + 1)
        for (i in vals.indices) {
            prefix[i + 1] = prefix[i] + (cnt[vals[i]] ?: 0)
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            var lo = 0
            var hi = vals.size
            while (lo < hi) {
                val mid = (lo + hi) / 2
                if (vals[mid] < queries[i]) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            result[i] = prefix[lo]
        }
        return result
    }
}
