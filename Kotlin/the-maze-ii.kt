package themazeii

import java.util.PriorityQueue

// Time:  O(max(r, c) * wlogw)
// Space: O(w)

class Solution {
    fun shortestDistance(maze: Array<IntArray>, start: IntArray, destination: IntArray): Int {
        val dirs = arrayOf(
            intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0)
        )
        val heap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }, { it[2] }))
        val visited = HashSet<Int>()
        heap.add(intArrayOf(0, start[0], start[1]))

        while (heap.isNotEmpty()) {
            val top = heap.poll()
            val dist = top[0]
            val node = intArrayOf(top[1], top[2])
            if (visited.contains(hash(maze, node))) {
                continue
            }
            if (node[0] == destination[0] && node[1] == destination[1]) {
                return dist
            }

            visited.add(hash(maze, node))
            for (dir in dirs) {
                val neighbor = findNeighbor(maze, node, dir)
                heap.add(intArrayOf(dist + neighbor[0], neighbor[1], neighbor[2]))
            }
        }

        return -1
    }

    private fun findNeighbor(maze: Array<IntArray>, node: IntArray, dir: IntArray): IntArray {
        var r = node[0]
        var c = node[1]
        var dist = 0
        while (r + dir[0] in maze.indices &&
            c + dir[1] in maze[0].indices &&
            maze[r + dir[0]][c + dir[1]] == 0
        ) {
            r += dir[0]
            c += dir[1]
            ++dist
        }
        return intArrayOf(dist, r, c)
    }

    private fun hash(maze: Array<IntArray>, node: IntArray): Int {
        return node[0] * maze[0].size + node[1]
    }
}
