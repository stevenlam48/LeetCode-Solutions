package unitconversioni

// Time:  O(n)
// Space: O(n)

class Solution {
    fun baseUnitConversions(conversions: Array<IntArray>): IntArray {
        val mod = 1_000_000_007
        val adj = Array(conversions.size + 1) { mutableListOf<Pair<Int, Int>>() }
        for (c in conversions) {
            adj[c[0]].add(c[1] to c[2])
        }
        val result = IntArray(adj.size)
        result[0] = 1
        var queue = listOf(0)
        while (queue.isNotEmpty()) {
            val newQueue = ArrayList<Int>()
            for (u in queue) {
                for ((v, w) in adj[u]) {
                    result[v] = (result[u].toLong() * w % mod).toInt()
                    newQueue.add(v)
                }
            }
            queue = newQueue
        }
        return result
    }
}
