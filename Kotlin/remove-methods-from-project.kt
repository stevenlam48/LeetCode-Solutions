package removemethodsfromproject

// Time:  O(n + e)
// Space: O(n + e)
class Solution {
    fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): IntArray {
        val adj = Array(n) { ArrayList<Int>() }
        for (e in invocations) {
            adj[e[0]].add(e[1])
        }

        val lookup = BooleanArray(n)
        lookup[k] = true
        var q = ArrayList<Int>()
        q.add(k)
        while (q.isNotEmpty()) {
            val newQ = ArrayList<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    newQ.add(v)
                }
            }
            q = newQ
        }

        for (e in invocations) {
            if (lookup[e[0]] != lookup[e[1]]) {
                return IntArray(n) { it }
            }
        }
        val result = ArrayList<Int>()
        for (u in 0 until n) {
            if (!lookup[u]) {
                result.add(u)
            }
        }
        return result.toIntArray()
    }
}
