package maximumprofitfromtradingstockswithdiscounts

// Time:  O(n * b)
// Space: O(n + b)

// iterative dfs, tree dp
class Solution {
    private class Frame(
        val step: Int,
        val u: Int,
        val i: Int,
        val newRet: MutableList<HashMap<Int, Int>>?,
        val ret: MutableList<HashMap<Int, Int>>
    )

    fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
        val adj = Array(n) { ArrayList<Int>() }
        for (h in hierarchy) {
            adj[h[0] - 1].add(h[1] - 1)
        }
        val ret = MutableList(2) { HashMap<Int, Int>() }
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            val step = frame.step
            val u = frame.u
            val i = frame.i
            val newRet = frame.newRet
            val cur = frame.ret
            if (step == 1) {
                cur[0][0] = 0
                cur[1][0] = 0
                stk.addLast(Frame(4, u, -1, null, cur))
                stk.addLast(Frame(2, u, 0, null, cur))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                val v = adj[u][i]
                stk.addLast(Frame(2, u, i + 1, null, cur))
                val childRet = MutableList(2) { HashMap<Int, Int>() }
                stk.addLast(Frame(3, -1, -1, childRet, cur))
                stk.addLast(Frame(1, v, -1, null, childRet))
            } else if (step == 3) {
                for (idx in 0 until 2) {
                    val copyDp = HashMap(cur[idx])
                    for ((j1, v1) in copyDp) {
                        for ((j2, v2) in newRet!![idx]) {
                            if (j1 + j2 <= budget) {
                                cur[idx][j1 + j2] = maxOf(cur[idx][j1 + j2] ?: 0, v1 + v2)
                            }
                        }
                    }
                }
            } else if (step == 4) {
                val next = MutableList(2) { HashMap<Int, Int>() }
                for (idx in 0 until 2) {
                    for ((j, v) in cur[0]) {
                        next[idx][j] = maxOf(next[idx][j] ?: 0, v)
                    }
                    val cost = present[u] shr idx
                    if (cost > budget) {
                        continue
                    }
                    val profit = future[u] - cost
                    for ((j, v) in cur[1]) {
                        if (j + cost <= budget) {
                            next[idx][j + cost] = maxOf(next[idx][j + cost] ?: 0, v + profit)
                        }
                    }
                }
                cur[0] = next[0]
                cur[1] = next[1]
            }
        }
        var result = 0
        for ((_, v) in ret[0]) {
            result = maxOf(result, v)
        }
        return result
    }
}
