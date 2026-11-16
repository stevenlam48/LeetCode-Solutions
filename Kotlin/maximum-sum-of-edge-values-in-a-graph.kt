package maximumsumofedgevaluesinagraph
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxScore(n: Int, edges: Array<IntArray>): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val lookup = BooleanArray(n)

        fun bfs(u0: Int): List<Int> {
            lookup[u0] = true
            val result = mutableListOf(u0)
            var i = 0
            while (i < result.size) {
                val u = result[i]
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    result.add(v)
                }
                ++i
            }
            return result
        }

        fun f(l: Int, r: Int, isCycle: Boolean): Long {
            var a = r.toLong()
            var b = r.toLong()
            var result = 0L
            var c = r - 1
            while (c >= l) {
                result += a * c
                val nb = c.toLong()
                a = b
                b = nb
                --c
            }
            if (isCycle) {
                result += a * b
            }
            return result
        }

        val chains = mutableListOf<Int>()
        val cycles = mutableListOf<Int>()
        for (u in 0 until n) {
            if (lookup[u]) {
                continue
            }
            val comp = bfs(u)
            if (comp.all { adj[it].size == 2 }) {
                cycles.add(comp.size)
            } else {
                chains.add(comp.size)
            }
        }
        var m = n
        var result = 0L
        for (l in cycles) {
            result += f(m - l + 1, m, true)
            m -= l
        }
        val maxChain = if (chains.isEmpty()) 0 else chains.max()
        val cnt = IntArray(maxChain + 1)
        for (l in chains) {
            ++cnt[l]
        }
        for (l in cnt.size - 1 downTo 0) {
            repeat(cnt[l]) {
                result += f(m - l + 1, m, false)
                m -= l
            }
        }
        return result
    }
}
