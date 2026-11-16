package cyclicallyrotatingagrid

// Time:  O(m * n)
// Space: O(1)

// inplace rotation
class Solution {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        var m = grid.size
        var n = grid[0].size
        val count = Math.min(m, n) / 2
        var i = 0
        while (i < count) {
            val total = 2 * ((m - 1) + (n - 1))
            val nk = k % total
            val numCycles = gcd(total, nk)
            val cycleLen = total / numCycles
            for (offset in 0 until numCycles) {
                val (r, c) = getIndex(m, n, offset)
                for (j in 1 until cycleLen) {
                    val (nr, nc) = getIndex(m, n, (offset + j * nk) % total)
                    val tmp = grid[i + nr][i + nc]
                    grid[i + nr][i + nc] = grid[i + r][i + c]
                    grid[i + r][i + c] = tmp
                }
            }
            i += 1
            m -= 2
            n -= 2
        }
        return grid
    }

    private fun getIndex(m: Int, n: Int, l: Int): Pair<Int, Int> {
        if (l < m - 1) {
            return Pair(l, 0)
        }
        if (l < (m - 1) + (n - 1)) {
            return Pair(m - 1, l - (m - 1))
        }
        if (l < (m - 1) + (n - 1) + (m - 1)) {
            return Pair((m - 1) - (l - ((m - 1) + (n - 1))), n - 1)
        }
        return Pair(0, (n - 1) - (l - ((m - 1) + (n - 1) + (m - 1))))
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val tmp = x % y
            x = y
            y = tmp
        }
        return x
    }
}
