package differencebetweenmaximumandminimumpricesum

// Time:  O(n)
// Space: O(n)

// iterative dfs, tree dp
class Solution {
    private data class Frame(
        val step: Int,
        val u: Int,
        val p: Int,
        val i: Int,
        val newRet: LongArray?,
        val ret: LongArray
    )

    fun maxOutput(n: Int, edges: Array<IntArray>, price: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        var result = 0L
        val ret = longArrayOf(price[0].toLong(), 0L)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, -1, null, ret))
        while (stk.isNotEmpty()) {
            val (step, u, p, i, newRet, curRet) = stk.removeLast()
            if (step == 1) {
                stk.addLast(Frame(2, u, p, 0, null, curRet))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                stk.addLast(Frame(2, u, p, i + 1, null, curRet))
                val v = adj[u][i]
                if (v == p) {
                    continue
                }
                val childRet = longArrayOf(price[v].toLong(), 0L)
                stk.addLast(Frame(3, u, -1, -1, childRet, curRet))
                stk.addLast(Frame(1, v, u, -1, null, childRet))
            } else if (step == 3) {
                val nr = newRet!!
                result = maxOf(result, curRet[0] + nr[1], curRet[1] + nr[0])
                curRet[0] = maxOf(curRet[0], nr[0] + price[u])
                curRet[1] = maxOf(curRet[1], nr[1] + price[u])
            }
        }
        return result
    }
}
