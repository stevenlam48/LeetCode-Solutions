package findtheminimumareatocoverallonesii

// Time:  O(max(n, m)^2)
// Space: O(max(n, m)^2)

// dp
class Solution {
    fun minimumSum(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        fun cmp(x: Int, y: Int): Int = if (x < y) -1 else if (x > y) 1 else 0

        fun count(start1: Int, end1: Int, start2: Int, end2: Int): Array<IntArray> {
            val dp = Array(n) { IntArray(m) }
            val up = IntArray(m) { n }
            val down = IntArray(m) { -1 }
            var i = start1
            val d1 = cmp(end1, start1)
            while (i != end1) {
                var l = m
                var r = -1
                var u = n
                var d = -1
                var j = start2
                val d2 = cmp(end2, start2)
                while (j != end2) {
                    if (grid[i][j] != 0) {
                        up[j] = minOf(up[j], i)
                        down[j] = maxOf(down[j], i)
                    }
                    u = minOf(u, up[j])
                    d = maxOf(d, down[j])
                    if (down[j] >= 0) {
                        l = minOf(l, j)
                        r = maxOf(r, j)
                    }
                    dp[i][j] = if (r >= 0) (r - l + 1) * (d - u + 1) else 0
                    j += d2
                }
                i += d1
            }
            return dp
        }

        fun count2(isVertical: Boolean): Array<IntArray> {
            val getN = if (!isVertical) n else m
            val getM = if (!isVertical) m else n

            fun get(i: Int, j: Int): Int = if (!isVertical) grid[i][j] else grid[j][i]

            val left = IntArray(getN) { getM }
            val right = IntArray(getN) { -1 }
            for (i in 0 until getN) {
                for (j in 0 until getM) {
                    if (get(i, j) == 0) {
                        continue
                    }
                    left[i] = minOf(left[i], j)
                    right[i] = maxOf(right[i], j)
                }
            }
            val dp = Array(getN) { IntArray(getN) }
            for (i in dp.indices) {
                var l = getM
                var r = -1
                var u = getN
                var d = -1
                for (j in i until dp[0].size) {
                    if (right[j] != -1) {
                        l = minOf(l, left[j])
                        r = maxOf(r, right[j])
                        u = minOf(u, j)
                        d = maxOf(d, j)
                    }
                    dp[i][j] = if (r >= 0) (r - l + 1) * (d - u + 1) else 0
                }
            }
            return dp
        }

        val upLeft = count(0, n, 0, m)
        val upRight = count(0, n, m - 1, -1)
        val downLeft = count(n - 1, -1, 0, m)
        val downRight = count(n - 1, -1, m - 1, -1)
        val horizon = count2(false)
        val vertical = count2(true)
        var result = Int.MAX_VALUE
        for (i in 0 until n - 1) {
            for (j in 0 until m - 1) {
                result = minOf(
                    result,
                    upLeft[i][j] + upRight[i][j + 1] + horizon[i + 1][n - 1],
                    horizon[0][i] + downLeft[i + 1][j] + downRight[i + 1][j + 1],
                    upLeft[i][j] + downLeft[i + 1][j] + vertical[j + 1][m - 1],
                    vertical[0][j] + upRight[i][j + 1] + downRight[i + 1][j + 1]
                )
            }
        }
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                result = minOf(result, horizon[0][i] + horizon[i + 1][j] + horizon[j + 1][n - 1])
            }
        }
        for (i in 0 until m - 2) {
            for (j in i + 1 until m - 1) {
                result = minOf(result, vertical[0][i] + vertical[i + 1][j] + vertical[j + 1][m - 1])
            }
        }
        return result
    }
}
