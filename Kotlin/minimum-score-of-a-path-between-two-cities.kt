package minimumscoreofapathbetweentwocities

// Time:  O(n + m), m = len(roads)
// Space: O(n + m)

class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (r in roads) {
            adj[r[0] - 1].add(Pair(r[1] - 1, r[2]))
            adj[r[1] - 1].add(Pair(r[0] - 1, r[2]))
        }
        val lookup = BooleanArray(n)
        lookup[0] = true
        var q = mutableListOf(0)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                for ((v, w) in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    newQ.add(v)
                }
            }
            q = newQ
        }
        var result = Int.MAX_VALUE
        for (r in roads) {
            if (lookup[r[0] - 1]) {
                result = minOf(result, r[2])
            }
        }
        return result
    }
}
