package shortestbridge

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun shortestBridge(a: Array<IntArray>): Int {
        val islands = getIslands(a)
        val lookup = islands[0].toMutableSet()
        val target = islands[1]
        val queue = java.util.ArrayDeque<Pair<Pair<Int, Int>, Int>>()
        for (node in lookup) {
            queue.add(node to 0)
        }
        while (queue.isNotEmpty()) {
            val (node, distance) = queue.removeFirst()
            if (target.contains(node)) {
                return distance - 1
            }
            for (d in directions) {
                val neighbor = (node.first + d.first) to (node.second + d.second)
                if (neighbor.first < 0 || neighbor.first >= a.size ||
                    neighbor.second < 0 || neighbor.second >= a[0].size ||
                    lookup.contains(neighbor)
                ) {
                    continue
                }
                queue.add(neighbor to distance + 1)
                lookup.add(neighbor)
            }
        }
        return -1
    }

    private fun getIslands(a: Array<IntArray>): List<MutableSet<Pair<Int, Int>>> {
        val islands = mutableListOf<MutableSet<Pair<Int, Int>>>()
        val done = mutableSetOf<Pair<Int, Int>>()
        for (r in a.indices) {
            for (c in a[0].indices) {
                if (a[r][c] == 0 || done.contains(r to c)) {
                    continue
                }
                val stack = mutableListOf(r to c)
                val lookup = mutableSetOf(r to c)
                while (stack.isNotEmpty()) {
                    val node = stack.removeAt(stack.lastIndex)
                    for (d in directions) {
                        val neighbor = (node.first + d.first) to (node.second + d.second)
                        if (neighbor.first < 0 || neighbor.first >= a.size ||
                            neighbor.second < 0 || neighbor.second >= a[0].size ||
                            lookup.contains(neighbor) || a[neighbor.first][neighbor.second] == 0
                        ) {
                            continue
                        }
                        stack.add(neighbor)
                        lookup.add(neighbor)
                    }
                }
                done.addAll(lookup)
                islands.add(lookup)
                if (islands.size == 2) {
                    break
                }
            }
        }
        return islands
    }

    private val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
}
