package nearestexitfromentranceinmaze
// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val directions = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
        maze[entrance[0]][entrance[1]] = '-'
        var left = hashSetOf(entrance[0] to entrance[1])
        var right = HashSet<Pair<Int, Int>>()
        for (r in 0 until maze.size - 1) {
            if (maze[r][0] == '.' && intArrayOf(r, 0).contentEquals(entrance).not()) {
                right.add(r to 0)
            }
        }
        for (c in 0 until maze[0].size - 1) {
            if (maze[maze.size - 1][c] == '.' && intArrayOf(maze.size - 1, c).contentEquals(entrance).not()) {
                right.add(maze.size - 1 to c)
            }
        }
        for (r in maze.size - 1 downTo 1) {
            if (maze[r][maze[0].size - 1] == '.' && intArrayOf(r, maze[0].size - 1).contentEquals(entrance).not()) {
                right.add(r to maze[0].size - 1)
            }
        }
        for (c in maze[0].size - 1 downTo 1) {
            if (maze[0][c] == '.' && intArrayOf(0, c).contentEquals(entrance).not()) {
                right.add(0 to c)
            }
        }
        var steps = 0
        while (left.isNotEmpty()) {
            for ((r, c) in left) {
                maze[r][c] = '-'
            }
            val newLeft = HashSet<Pair<Int, Int>>()
            for (pos in left) {
                if (pos in right) {
                    return steps
                }
                for ((dr, dc) in directions) {
                    val nei = pos.first + dr to pos.second + dc
                    if (nei.first !in maze.indices || nei.second !in maze[0].indices || maze[nei.first][nei.second] != '.') {
                        continue
                    }
                    newLeft.add(nei)
                }
            }
            left = newLeft
            ++steps
            if (left.size > right.size) {
                val temp = left
                left = right
                right = temp
            }
        }
        return -1
    }
}
