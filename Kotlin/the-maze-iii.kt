package themazeiii

import java.util.PriorityQueue

// Time:  O(max(r, c) * wlogw)
// Space: O(w^2)

class Solution {
    private data class Node(val dist: Int, val path: String, val r: Int, val c: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int {
            if (dist != other.dist) {
                return dist.compareTo(other.dist)
            }
            if (path != other.path) {
                return path.compareTo(other.path)
            }
            if (r != other.r) {
                return r.compareTo(other.r)
            }
            return c.compareTo(other.c)
        }
    }

    fun findShortestWay(maze: Array<IntArray>, ball: IntArray, hole: IntArray): String {
        val dirs = listOf(
            "u" to intArrayOf(-1, 0),
            "r" to intArrayOf(0, 1),
            "l" to intArrayOf(0, -1),
            "d" to intArrayOf(1, 0)
        )
        val heap = PriorityQueue<Node>()
        val visited = HashSet<Int>()
        heap.add(Node(0, "", ball[0], ball[1]))

        while (heap.isNotEmpty()) {
            val top = heap.poll()
            val node = intArrayOf(top.r, top.c)
            if (visited.contains(hash(maze, node))) {
                continue
            }

            if (node[0] == hole[0] && node[1] == hole[1]) {
                return top.path
            }

            visited.add(hash(maze, node))
            for ((dir, vec) in dirs) {
                val neighbor = findNeighbor(maze, hole, node, vec)
                heap.add(Node(top.dist + neighbor[0], top.path + dir, neighbor[1], neighbor[2]))
            }
        }

        return "impossible"
    }

    private fun findNeighbor(maze: Array<IntArray>, hole: IntArray, node: IntArray, vec: IntArray): IntArray {
        var r = node[0]
        var c = node[1]
        var dist = 0
        while (r + vec[0] in maze.indices &&
            c + vec[1] in maze[0].indices &&
            maze[r + vec[0]][c + vec[1]] == 0
        ) {
            r += vec[0]
            c += vec[1]
            ++dist
            if (r == hole[0] && c == hole[1]) {
                break
            }
        }
        return intArrayOf(dist, r, c)
    }

    private fun hash(maze: Array<IntArray>, node: IntArray): Int {
        return node[0] * maze[0].size + node[1]
    }
}
