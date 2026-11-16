package powergridmaintenance
// Time:  O(c + n + q), n = len(connections)
// Space: O(c + n)

class Solution {
    fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(c) { mutableListOf<Int>() }
        for (connection in connections) {
            adj[connection[0] - 1].add(connection[1] - 1)
            adj[connection[1] - 1].add(connection[0] - 1)
        }
        val lookup = IntArray(c) { -1 }
        fun iterDfs(i: Int) {
            val stk = mutableListOf(i)
            while (stk.isNotEmpty()) {
                val u = stk.removeAt(stk.lastIndex)
                if (lookup[u] != -1) {
                    continue
                }
                lookup[u] = i
                for (v in adj[u]) {
                    stk.add(v)
                }
            }
        }
        for (i in 0 until c) {
            iterDfs(i)
        }
        val groups = Array(c) { mutableListOf<Int>() }
        for (i in c - 1 downTo 0) {
            groups[lookup[i]].add(i)
        }
        val result = mutableListOf<Int>()
        val online = BooleanArray(c) { true }
        for (q in queries) {
            val t = q[0]
            val x = q[1] - 1
            if (t == 1) {
                if (online[x]) {
                    result.add(x + 1)
                    continue
                }
                while (groups[lookup[x]].isNotEmpty() && !online[groups[lookup[x]].last()]) {
                    groups[lookup[x]].removeAt(groups[lookup[x]].lastIndex)
                }
                result.add(if (groups[lookup[x]].isNotEmpty()) groups[lookup[x]].last() + 1 else -1)
            } else {
                online[x] = false
            }
        }
        return result.toIntArray()
    }
}
