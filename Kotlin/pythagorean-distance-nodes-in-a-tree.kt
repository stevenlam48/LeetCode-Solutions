package pythagoreandistancenodesinatree

// Time:  O(n)
// Space: O(n)

// bfs
class Solution {
    fun specialNodes(n: Int, edges: Array<IntArray>, x: Int, y: Int, z: Int): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        fun bfs(u: Int): IntArray {
            val dist = IntArray(n) { -1 }
            dist[u] = 0
            var q = mutableListOf(u)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u2 in q) {
                    for (v in adj[u2]) {
                        if (dist[v] != -1) {
                            continue
                        }
                        dist[v] = dist[u2] + 1
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            return dist
        }

        val dist1 = bfs(x)
        val dist2 = bfs(y)
        val dist3 = bfs(z)
        var result = 0
        for (u in 0 until n) {
            val a = dist1[u].toLong()
            val b = dist2[u].toLong()
            val c = dist3[u].toLong()
            val mx = maxOf(a, b, c)
            if (a * a + b * b + c * c == 2 * mx * mx) {
                ++result
            }
        }
        return result
    }
}
