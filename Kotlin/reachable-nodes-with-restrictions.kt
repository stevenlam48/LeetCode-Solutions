package reachablenodeswithrestrictions
// Time:  O(n)
// Space: O(n)
class Solution {
    fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        var result = 0
        val lookup = BooleanArray(n)
        for (x in restricted) {
            lookup[x] = true
        }
        var queue = mutableListOf(0)
        lookup[0] = true
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Int>()
            for (u in queue) {
                result++
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    newQueue.add(v)
                }
            }
            queue = newQueue
        }
        return result
    }
}
