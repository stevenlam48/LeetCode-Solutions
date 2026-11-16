package countunguardedcellsinthegrid

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )
        val grid = Array(m) { IntArray(n) }
        for (x in guards) {
            grid[x[0]][x[1]] = 2
        }
        for (x in walls) {
            grid[x[0]][x[1]] = 2
        }
        for (x in guards) {
            for ((dr, dc) in directions) {
                var nr = x[0] + dr
                var nc = x[1] + dc
                while (nr in 0 until m && nc in 0 until n && grid[nr][nc] != 2) {
                    grid[nr][nc] = 1
                    nr += dr
                    nc += dc
                }
            }
        }
        var result = 0
        for (row in grid) {
            for (x in row) {
                result += if (x == 0) 1 else 0
            }
        }
        return result
    }
}
