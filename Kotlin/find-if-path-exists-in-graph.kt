package findifpathexistsingraph

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

// bi-bfs solution
class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val adj = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            adj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            adj.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }
        return biBfs(adj, start, end) >= 0
    }

    private fun biBfs(adj: HashMap<Int, MutableList<Int>>, start: Int, target: Int): Int {
        var left = hashSetOf(start)
        var right = hashSetOf(target)
        val lookup = HashSet<Int>()
        var steps = 0
        while (left.isNotEmpty()) {
            for (pos in left) {
                lookup.add(pos)
            }
            val newLeft = HashSet<Int>()
            for (pos in left) {
                if (pos in right) {
                    return steps
                }
                val neighbors = adj[pos] ?: continue
                for (nei in neighbors) {
                    if (nei in lookup) {
                        continue
                    }
                    newLeft.add(nei)
                }
            }
            left = newLeft
            ++steps
            if (left.size > right.size) {
                val tmp = left
                left = right
                right = tmp
            }
        }
        return -1
    }
}
