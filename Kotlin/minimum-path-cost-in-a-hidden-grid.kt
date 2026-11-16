package minimumpathcostinahiddengrid
// Time:  O(m * n * log(m * n))
// Space: O(m * n)

import java.util.PriorityQueue

interface GridMaster {
    fun canMove(direction: Char): Boolean
    fun move(direction: Char): Int
    fun isTarget(): Boolean
}

class Solution {
    fun findShortestPath(master: GridMaster): Int {
        val start = MAX_M to MAX_N
        var target = 0 to 0
        var found = false
        val lookup = HashSet<Int>()
        val adj = HashMap<Int, HashMap<Int, Int>>()

        fun dfs(pos: Pair<Int, Int>) {
            if (!found && master.isTarget()) {
                found = true
                target = pos
            }
            lookup.add(index(pos))
            for ((d, dir) in directions) {
                if (!master.canMove(d)) {
                    continue
                }
                val nei = (pos.first + dir.first) to (pos.second + dir.second)
                if (adj[index(pos)]?.containsKey(index(nei)) == true) {
                    continue
                }
                adj.getOrPut(index(pos)) { HashMap() }[index(nei)] = master.move(d)
                if (!lookup.contains(index(nei))) {
                    dfs(nei)
                }
                adj.getOrPut(index(nei)) { HashMap() }[index(pos)] = master.move(rollback.getValue(d))
            }
        }

        dfs(start)
        return if (found) dijkstra(adj, start, target) else -1
    }

    private fun index(p: Pair<Int, Int>): Int {
        return (2 * MAX_N + 1) * p.first + p.second
    }

    private fun dijkstra(
        adj: HashMap<Int, HashMap<Int, Int>>,
        start: Pair<Int, Int>,
        target: Pair<Int, Int>
    ): Int {
        val dist = hashMapOf(index(start) to 0)
        val minHeap = PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        )
        minHeap.add(0 to index(start))
        while (minHeap.isNotEmpty()) {
            val (curr, u) = minHeap.remove()
            if (dist.getValue(u) < curr) {
                continue
            }
            for ((v, w) in adj[u].orEmpty()) {
                if (dist.containsKey(v) && dist.getValue(v) - curr <= w) {
                    continue
                }
                dist[v] = curr + w
                minHeap.add(curr + w to v)
            }
        }
        return dist[index(target)] ?: -1
    }

    private companion object {
        const val MAX_M = 100
        const val MAX_N = 100
        val rollback = mapOf('L' to 'R', 'R' to 'L', 'U' to 'D', 'D' to 'U')
        val directions = mapOf(
            'L' to (0 to -1),
            'R' to (0 to 1),
            'U' to (-1 to 0),
            'D' to (1 to 0)
        )
    }
}
