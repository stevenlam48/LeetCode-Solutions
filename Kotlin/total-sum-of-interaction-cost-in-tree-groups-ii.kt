package totalsumofinteractioncostintreegroupsii

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun interactionCosts(n: Int, edges: Array<IntArray>, group: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        val order = ArrayList<Int>(n)
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(0, -1))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val u = top[0]
            val p = top[1]
            order.add(u)
            for (i in adj[u].indices.reversed()) {
                val v = adj[u][i]
                if (v == p) {
                    continue
                }
                stk.addLast(intArrayOf(v, u))
            }
        }

        val total = LongArray(n)
        fun count(g: Int, c: Long): Long {
            return c * (total[g] - c)
        }

        for (g in group) {
            ++total[g - 1]
        }
        val cnt = Array(n) { HashMap<Int, Long>() }
        val cnt2 = LongArray(n)
        var result = 0L
        for (u in order.asReversed()) {
            cnt[u][group[u] - 1] = 1L
            cnt2[u] = count(group[u] - 1, 1L)
            for (v in adj[u]) {
                if (cnt[v].isEmpty()) {
                    continue
                }
                if (cnt[u].size < cnt[v].size) {
                    val tmp = cnt[u]
                    cnt[u] = cnt[v]
                    cnt[v] = tmp
                    val tmp2 = cnt2[u]
                    cnt2[u] = cnt2[v]
                    cnt2[v] = tmp2
                }
                for ((g, c) in cnt[v]) {
                    cnt2[u] -= count(g, cnt[u][g] ?: 0L)
                    cnt[u][g] = (cnt[u][g] ?: 0L) + c
                    cnt2[u] += count(g, cnt[u][g]!!)
                }
                cnt[v].clear()
            }
            result += cnt2[u]
        }
        return result
    }
}
