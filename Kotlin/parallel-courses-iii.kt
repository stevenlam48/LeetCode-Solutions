package parallelcoursesiii

// Time:  O(|V| + |E|)
// Space: O(|E|)

class Solution {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        val inDegree = IntArray(n)
        for (relation in relations) {
            adj[relation[0] - 1].add(relation[1] - 1)
            ++inDegree[relation[1] - 1]
        }
        var q = ArrayList<Int>()
        val dist = IntArray(n)
        for (u in 0 until n) {
            if (inDegree[u] != 0) {
                continue
            }
            q.add(u)
            dist[u] = time[u]
        }
        while (q.isNotEmpty()) {
            val newQ = ArrayList<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    dist[v] = maxOf(dist[v], dist[u] + time[v])
                    --inDegree[v]
                    if (inDegree[v] == 0) {
                        newQ.add(v)
                    }
                }
            }
            q = newQ
        }
        return dist.max()
    }
}
