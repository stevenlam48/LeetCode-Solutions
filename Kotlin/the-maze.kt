package themaze

// Time:  O(max(r, c) * w)
// Space: O(w)

class Solution {
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        val dirs = arrayOf(
            intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0)
        )
        val q = ArrayDeque<IntArray>()
        val visited = HashSet<Int>()
        q.addLast(start.copyOf())

        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            if (visited.contains(hash(maze, node))) {
                continue
            }
            if (node[0] == destination[0] && node[1] == destination[1]) {
                return true
            }

            visited.add(hash(maze, node))
            for (dir in dirs) {
                q.addLast(findNeighbor(maze, node, dir))
            }
        }

        return false
    }

    private fun findNeighbor(maze: Array<IntArray>, node: IntArray, dir: IntArray): IntArray {
        val cur = node.copyOf()
        while (cur[0] + dir[0] in maze.indices &&
            cur[1] + dir[1] in maze[0].indices &&
            maze[cur[0] + dir[0]][cur[1] + dir[1]] == 0
        ) {
            cur[0] += dir[0]
            cur[1] += dir[1]
        }
        return cur
    }

    private fun hash(maze: Array<IntArray>, node: IntArray): Int {
        return node[0] * maze[0].size + node[1]
    }
}
