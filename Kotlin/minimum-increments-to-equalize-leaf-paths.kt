package minimumincrementstoequalizeleafpaths
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minIncrease(n: Int, edges: Array<IntArray>, cost: IntArray): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        var result = n - 1
        val mx = LongArray(n)
        val stk = ArrayList<Triple<Int, Int, Int>>()
        stk.add(Triple(1, 0, -1))
        while (stk.isNotEmpty()) {
            val (step, u, p) = stk.removeAt(stk.lastIndex)
            if (step == 1) {
                stk.add(Triple(2, u, p))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    stk.add(Triple(1, v, u))
                }
            } else if (step == 2) {
                var cnt = 0
                for (v in adj[u]) {
                    if (v == p || mx[v] < mx[u]) {
                        continue
                    }
                    if (mx[v] > mx[u]) {
                        mx[u] = mx[v]
                        cnt = 0
                    }
                    ++cnt
                }
                result -= cnt
                mx[u] += cost[u]
            }
        }
        return result
    }
}
