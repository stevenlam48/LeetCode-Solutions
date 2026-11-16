package shortestpathwithalternatingcolors

// Time:  O(n + e), e is the number of red and blue edges
// Space: O(n + e)

class Solution {
    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val neighbors = Array(n) { arrayOf(HashSet<Int>(), HashSet<Int>()) }
        for (edge in redEdges) {
            neighbors[edge[0]][0].add(edge[1])
        }
        for (edge in blueEdges) {
            neighbors[edge[0]][1].add(edge[1])
        }
        val inf = maxOf(2 * n - 3, 0) + 1
        val dist = Array(n) { IntArray(2) { inf } }
        dist[0][0] = 0
        dist[0][1] = 0
        val q = ArrayDeque<Pair<Int, Int>>()
        q.addLast(0 to 0)
        q.addLast(0 to 1)
        while (q.isNotEmpty()) {
            val (i, c) = q.removeFirst()
            for (j in neighbors[i][c]) {
                if (dist[j][c] != inf) {
                    continue
                }
                dist[j][c] = dist[i][1 xor c] + 1
                q.addLast(j to (1 xor c))
            }
        }
        return IntArray(n) { i ->
            val x = minOf(dist[i][0], dist[i][1])
            if (x != inf) x else -1
        }
    }
}
