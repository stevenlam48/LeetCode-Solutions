package magicsquaresingrid

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
        var result = 0
        var i = 0
        while (i + K - 1 < grid.size) {
            var j = 0
            while (j + K - 1 < grid[j].size) {
                if (magic(grid, i, j)) {
                    ++result
                }
                ++j
            }
            ++i
        }
        return result
    }

    private fun magic(grid: Array<IntArray>, r: Int, c: Int): Boolean {
        val expect = K * (K * K + 1) / 2
        val nums = HashSet<Int>()
        var minNum = Int.MAX_VALUE
        var sumDiag = 0
        var sumAnti = 0
        for (i in 0 until K) {
            sumDiag += grid[r + i][c + i]
            sumAnti += grid[r + i][c + K - 1 - i]
            var sumR = 0
            var sumC = 0
            for (j in 0 until K) {
                minNum = minOf(minNum, grid[r + i][c + j])
                nums.add(grid[r + i][c + j])
                sumR += grid[r + i][c + j]
                sumC += grid[r + j][c + i]
            }
            if (!(sumR == sumC && sumC == expect)) {
                return false
            }
        }
        return sumDiag == sumAnti &&
            sumAnti == expect &&
            nums.size == K * K &&
            minNum == 1
    }

    private companion object {
        const val K = 3
    }
}
