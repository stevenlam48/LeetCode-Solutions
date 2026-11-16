package countvisitednodesinadirectedgraph

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countVisitedNodes(edges: IntArray): IntArray {
        val n = edges.size
        val result = IntArray(n)
        val lookup = IntArray(n)
        val stk = IntArray(n)
        var idx = 0
        for (i in 0 until n) {
            var u = i
            val prev = idx
            var top = 0
            while (lookup[u] == 0) {
                lookup[u] = ++idx
                stk[top++] = u
                u = edges[u]
            }
            if (lookup[u] > prev) {
                val l = idx - lookup[u] + 1
                repeat(l) {
                    result[stk[--top]] = l
                }
            }
            while (top > 0) {
                val v = stk[--top]
                result[v] = result[edges[v]] + 1
            }
        }
        return result
    }
}
