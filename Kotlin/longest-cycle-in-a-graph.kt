package longestcycleinagraph

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestCycle(edges: IntArray): Int {
        var result = -1
        val lookup = IntArray(edges.size) { -1 }
        var idx = 0
        for (i in edges.indices) {
            if (lookup[i] != -1) {
                continue
            }
            val start = idx
            var j = i
            while (j != -1) {
                if (lookup[j] != -1) {
                    break
                }
                lookup[j] = idx++
                j = edges[j]
            }
            if (j != -1 && lookup[j] >= start) {
                result = maxOf(result, idx - lookup[j])
            }
        }
        return result
    }
}
