package maximumnumberofmovestokillallpawns
// Time:  O(p * n^2 + p^2 + p^2 * 2^p) = O(p^2 * 2^p)
// Space: O(p^2 + n^2 + p * 2^p) = O(p * 2^p)

class Solution {
    fun maxMoves(kx: Int, ky: Int, positions: Array<IntArray>): Int {
        val p = positions.size
        val allPositions = Array(p + 1) { i ->
            if (i < p) positions[i] else intArrayOf(kx, ky)
        }
        val dist = Array(p + 1) { IntArray(p + 1) }
        for (i in 0..p) {
            val d = bfs(allPositions[i][0], allPositions[i][1])
            for (j in i + 1..p) {
                dist[j][i] = d[allPositions[j][0]][allPositions[j][1]]
                dist[i][j] = dist[j][i]
            }
        }
        val dp = Array(1 shl p) { IntArray(p) }
        for (mask in 1 until (1 shl p)) {
            dp[mask].fill(if ((mask.countOneBits() and 1) != 0) POS_INF else NEG_INF)
        }
        dp.last().fill(0)
        for (mask in (1 shl p) - 1 downTo 1) {
            val turn = (mask.countOneBits() and 1) xor 1
            for (i in 0 until p) {
                if ((mask and (1 shl i)) == 0) {
                    continue
                }
                for (j in 0 until p) {
                    if (j == i || (mask and (1 shl j)) == 0) {
                        continue
                    }
                    val nextMask = mask xor (1 shl i)
                    dp[nextMask][j] = if (turn != 0) {
                        minOf(dp[nextMask][j], dp[mask][i] + dist[i][j])
                    } else {
                        maxOf(dp[nextMask][j], dp[mask][i] + dist[i][j])
                    }
                }
            }
        }
        var result = 0
        for (i in 0 until p) {
            result = maxOf(result, dp[1 shl i][i] + dist[i][p])
        }
        return result
    }

    private fun bfs(r: Int, c: Int): Array<IntArray> {
        val dist = Array(BOARD_SIZE) { IntArray(BOARD_SIZE) { POS_INF } }
        dist[r][c] = 0
        var q = listOf(Pair(r, c))
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Pair<Int, Int>>()
            for ((row, col) in q) {
                for ((dr, dc) in DIRECTIONS) {
                    val nr = row + dr
                    val nc = col + dc
                    if (!(0 <= nr && nr < BOARD_SIZE && 0 <= nc && nc < BOARD_SIZE && dist[nr][nc] == POS_INF)) {
                        continue
                    }
                    dist[nr][nc] = dist[row][col] + 1
                    newQ.add(Pair(nr, nc))
                }
            }
            q = newQ
        }
        return dist
    }

    companion object {
        private const val BOARD_SIZE = 50
        private const val POS_INF = Int.MAX_VALUE
        private const val NEG_INF = Int.MIN_VALUE
        private val DIRECTIONS = arrayOf(
            Pair(1, 2), Pair(-1, 2), Pair(1, -2), Pair(-1, -2),
            Pair(2, 1), Pair(-2, 1), Pair(2, -1), Pair(-2, -1)
        )
    }
}
