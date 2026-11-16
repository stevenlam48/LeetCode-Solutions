package shortestdistanceafterroadadditionqueriesi

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val adjacency = MutableList(n) { mutableListOf<Int>() }
        for (u in 0 until n - 1) {
            adjacency[u].add(u + 1)
        }
        val distance = IntArray(n) { it }
        fun bfs(u: Int, v: Int): Int {
            adjacency[u].add(v)
            var queue = mutableListOf(u)
            while (queue.isNotEmpty()) {
                val newQueue = mutableListOf<Int>()
                for (node in queue) {
                    for (neighbor in adjacency[node]) {
                        if (distance[node] + 1 >= distance[neighbor]) {
                            continue
                        }
                        distance[neighbor] = distance[node] + 1
                        newQueue.add(neighbor)
                    }
                }
                queue = newQueue
            }
            return distance[n - 1]
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            result[i] = bfs(queries[i][0], queries[i][1])
        }
        return result
    }
}
