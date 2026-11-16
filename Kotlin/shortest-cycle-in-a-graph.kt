package shortestcycleinagraph

// Time:  O(n^2)
// Space: O(n + e)

class Solution {
    fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
        val adjacency = MutableList(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1])
            adjacency[edge[1]].add(edge[0])
        }
        var result = Int.MAX_VALUE
        for (u in 0 until n) {
            result = minOf(result, bfs(u, n, adjacency))
        }
        return if (result != Int.MAX_VALUE) result else -1
    }

    private fun bfs(start: Int, n: Int, adjacency: List<MutableList<Int>>): Int {
        var result = Int.MAX_VALUE
        val distance = IntArray(n) { Int.MAX_VALUE }
        distance[start] = 0
        var queue = mutableListOf(start)
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Int>()
            for (u in queue) {
                for (v in adjacency[u]) {
                    if (distance[v] != Int.MAX_VALUE) {
                        if (distance[v] != distance[u] - 1) {
                            result = minOf(result, 1 + distance[u] + distance[v])
                        }
                        continue
                    }
                    distance[v] = distance[u] + 1
                    newQueue.add(v)
                }
            }
            if (result != Int.MAX_VALUE) {
                break
            }
            queue = newQueue
        }
        return result
    }
}
