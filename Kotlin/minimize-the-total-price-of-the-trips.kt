package minimizethetotalpriceofthetrips

// Time:  O(t * n)
// Space: O(n)

class Solution {
    private class Frame(val step: Int, val u: Int, val p: Int, val newRet: IntArray?, val ret: IntArray)

    fun minimumTotalPrice(n: Int, edges: Array<IntArray>, price: IntArray, trips: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val lookup = IntArray(n)

        fun iterDfs(u0: Int, target: Int) {
            val stk = ArrayDeque<IntArray>()
            stk.addLast(intArrayOf(1, u0, -1, target))
            while (stk.isNotEmpty()) {
                val f = stk.removeLast()
                val step = f[0]
                val u = f[1]
                val p = f[2]
                val t = f[3]
                if (step == 1) {
                    ++lookup[u]
                    if (u == t) {
                        return
                    }
                    stk.addLast(intArrayOf(2, u, p, t))
                    for (v in adj[u]) {
                        if (v == p) {
                            continue
                        }
                        stk.addLast(intArrayOf(1, v, u, t))
                    }
                } else if (step == 2) {
                    --lookup[u]
                }
            }
        }

        for (t in trips) {
            iterDfs(t[0], t[1])
        }

        val result = intArrayOf(price[0] * lookup[0], (price[0] / 2) * lookup[0])
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, null, result))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                for (v in adj[f.u]) {
                    if (v == f.p) {
                        continue
                    }
                    val nr = intArrayOf(price[v] * lookup[v], (price[v] / 2) * lookup[v])
                    stk.addLast(Frame(2, -1, -1, nr, f.ret))
                    stk.addLast(Frame(1, v, f.u, null, nr))
                }
            } else {
                f.ret[0] += minOf(f.newRet!![0], f.newRet[1])
                f.ret[1] += f.newRet[0]
            }
        }
        return minOf(result[0], result[1])
    }
}
