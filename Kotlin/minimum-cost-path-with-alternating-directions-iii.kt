package minimumcostpathwithalternatingdirectionsiii

// Time:  O((m * n) * log(m * n))
// Space: O(m * n)

class Solution {
    fun minCost(m: Int, n: Int, penalty: Array<IntArray>): Long {
        val DIRECTIONS = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, -1),
            intArrayOf(0, -1, 0)
        )

        val dist = Array(2) { Array(m) { LongArray(n) { Long.MAX_VALUE } } }
        dist[0][0][0] = 1L
        val minHeap = java.util.PriorityQueue<LongArray>(Comparator { a, b ->
            var cmp = a[0].compareTo(b[0])
            if (cmp == 0) cmp = a[1].compareTo(b[1])
            if (cmp == 0) cmp = a[2].compareTo(b[2])
            if (cmp == 0) cmp = a[3].compareTo(b[3])
            cmp
        })
        minHeap.add(longArrayOf(1L, 0L, 0L, 0L))
        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val w = cur[0]
            val p = cur[1].toInt()
            val i = cur[2].toInt()
            val j = cur[3].toInt()
            if (w != dist[p][i][j]) {
                continue
            }
            if (i == m - 1 && j == n - 1) {
                return w
            }
            if (w + penalty[i][j] < dist[p xor 1][i][j]) {
                dist[p xor 1][i][j] = w + penalty[i][j]
                minHeap.add(longArrayOf(dist[p xor 1][i][j], (p xor 1).toLong(), i.toLong(), j.toLong()))
            }
            for (dir in DIRECTIONS) {
                val np = p xor 1
                val ni = i + dir[1]
                val nj = j + dir[2]
                if (!(0 <= ni && ni < m && 0 <= nj && nj < n)) {
                    continue
                }
                val cand = w + (ni + 1).toLong() * (nj + 1) + (if (np != dir[0]) penalty[i][j].toLong() else 0L)
                if (cand >= dist[np][ni][nj]) {
                    continue
                }
                dist[np][ni][nj] = cand
                minHeap.add(longArrayOf(cand, np.toLong(), ni.toLong(), nj.toLong()))
            }
        }
        return -1
    }
}
