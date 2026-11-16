package findrootofacoloredtree

// Time:  O(n)
// Space: O(n)

// graph
class Solution {
    fun findColoredRoot(edges: Array<IntArray>, colors: String): Int {
        val lookup = mapOf('R' to 0, 'B' to 1, 'W' to 2)

        val inDegree = IntArray(edges.size + 1)
        val outDegree = IntArray(edges.size + 1)
        for (e in edges) {
            var u = e[0]
            var v = e[1]
            val x = lookup[colors[u]]!!
            val y = lookup[colors[v]]!!
            if (x == y) {
                return -1
            }
            if ((x + 1) % 3 != y) {
                val tmp = u
                u = v
                v = tmp
            }
            ++outDegree[u]
            ++inDegree[v]
        }
        return if (outDegree.maxOrNull()!! <= 2 && inDegree.maxOrNull()!! <= 1) inDegree.indexOf(0) else -1
    }
}
