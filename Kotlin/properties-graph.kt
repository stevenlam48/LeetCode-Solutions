package propertiesgraph

// Time:  O(n^2 * m)
// Space: O(n * m)

class Solution {
    fun numberOfComponents(properties: Array<IntArray>, k: Int): Int {
        val adj = Array(properties.size) { mutableListOf<Int>() }
        val pSet = Array(properties.size) { i -> properties[i].toHashSet() }
        for (i in pSet.indices) {
            for (j in i + 1 until pSet.size) {
                var cnt = 0
                for (x in pSet[i]) {
                    if (pSet[j].contains(x)) {
                        ++cnt
                    }
                }
                if (cnt >= k) {
                    adj[i].add(j)
                    adj[j].add(i)
                }
            }
        }
        val lookup = BooleanArray(properties.size)
        fun bfs(u: Int) {
            var q = listOf(u)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (node in q) {
                    for (v in adj[node]) {
                        if (lookup[v]) {
                            continue
                        }
                        lookup[v] = true
                        newQ.add(v)
                    }
                }
                q = newQ
            }
        }
        var result = 0
        for (i in properties.indices) {
            if (lookup[i]) {
                continue
            }
            bfs(i)
            ++result
        }
        return result
    }
}
