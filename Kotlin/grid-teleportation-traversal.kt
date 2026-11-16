package gridteleportationtraversal

// Time:  O(m * n)
// Space: O(m * n)

// 0-1 bfs
class Solution {
    fun minMoves(matrix: List<String>): Int {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val m = matrix.size
        val n = matrix[0].length
        val lookup = Array(26) { ArrayList<IntArray>() }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == '.' || matrix[i][j] == '#') {
                    continue
                }
                lookup[matrix[i][j] - 'A'].add(intArrayOf(i, j))
            }
        }
        val lookup2 = Array(m) { BooleanArray(n) }
        val dq = java.util.ArrayDeque<IntArray>()
        dq.add(intArrayOf(0, 0, 0))
        while (!dq.isEmpty()) {
            val cur = dq.pollFirst()
            val step = cur[0]
            val i = cur[1]
            val j = cur[2]
            if (lookup2[i][j]) {
                continue
            }
            lookup2[i][j] = true
            if (i == m - 1 && j == n - 1) {
                return step
            }
            for (d in directions) {
                val ni = i + d[0]
                val nj = j + d[1]
                if (!(0 <= ni && ni < m && 0 <= nj && nj < n && matrix[ni][nj] != '#' && !lookup2[ni][nj])) {
                    continue
                }
                dq.addLast(intArrayOf(step + 1, ni, nj))
            }
            if (matrix[i][j] == '.') {
                continue
            }
            for (p in lookup[matrix[i][j] - 'A']) {
                if (lookup2[p[0]][p[1]]) {
                    continue
                }
                dq.addFirst(intArrayOf(step, p[0], p[1]))
            }
            lookup[matrix[i][j] - 'A'].clear()
        }
        return -1
    }
}
