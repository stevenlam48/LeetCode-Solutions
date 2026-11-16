package restorethearrayfromadjacentpairs

// Time:  O(n)
// Space: O(n)

class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>()
        for (pair in adjacentPairs) {
            adj.getOrPut(pair[0]) { ArrayList() }.add(pair[1])
            adj.getOrPut(pair[1]) { ArrayList() }.add(pair[0])
        }
        val result = ArrayList<Int>()
        for ((first, neighbors) in adj) {
            if (neighbors.size == 1) {
                result.add(first)
                result.add(neighbors[0])
                break
            }
        }
        while (result.size != adjacentPairs.size + 1) {
            val last = result[result.size - 1]
            val neighbors = adj[last]!!
            val prev = result[result.size - 2]
            result.add(neighbors[if (neighbors[0] == prev) 1 else 0])
        }
        return result.toIntArray()
    }
}
