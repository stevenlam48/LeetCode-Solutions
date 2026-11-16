package minimumnumberofflipstomakebinarygridpalindromici

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun minFlips(grid: Array<IntArray>): Int {
        fun count(m: Int, n: Int, get: (Int, Int) -> Int): Int {
            var result = 0
            for (i in 0 until m) {
                for (j in 0 until n / 2) {
                    if (get(i, j) != get(i, n - 1 - j)) {
                        ++result
                    }
                }
            }
            return result
        }

        return minOf(
            count(grid.size, grid[0].size) { i, j -> grid[i][j] },
            count(grid[0].size, grid.size) { i, j -> grid[j][i] }
        )
    }
}
