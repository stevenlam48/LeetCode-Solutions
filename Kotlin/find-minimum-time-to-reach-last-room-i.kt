package findminimumtimetoreachlastroomi

import java.util.PriorityQueue

// Time:  O(n * m * logn(n * m))
// Space: O(n * m)

class Solution {
    fun minTimeToReach(moveTime: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))

        val n = moveTime.size
        val m = moveTime[0].size
        val dist = Array(n) { IntArray(m) { INF } }
        dist[0][0] = 0
        val minHeap = PriorityQueue<IntArray>(compareBy { it[0] })
        minHeap.add(intArrayOf(dist[0][0], 0, 0))
        while (minHeap.isNotEmpty()) {
            val top = minHeap.poll()
            val curr = top[0]
            val i = top[1]
            val j = top[2]
            if (curr != dist[i][j]) {
                continue
            }
            if (i == n - 1 && j == m - 1) {
                break
            }
            for (d in directions) {
                val ni = i + d[0]
                val nj = j + d[1]
                val c = 1
                if (!(0 <= ni && ni < n && 0 <= nj && nj < m && dist[ni][nj] > maxOf(moveTime[ni][nj], curr) + c)) {
                    continue
                }
                dist[ni][nj] = maxOf(moveTime[ni][nj], curr) + c
                minHeap.add(intArrayOf(dist[ni][nj], ni, nj))
            }
        }
        return dist[n - 1][m - 1]
    }
}
