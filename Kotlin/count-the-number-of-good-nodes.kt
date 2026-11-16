package countthenumberofgoodnodes

// Time:  O(n)
// Space: O(h)

// iterative dfs
private class Frame(
    val step: Int,
    val u: Int,
    val p: Int,
    val i: Int,
    val newRet: IntArray?,
    val l: IntArray?,
    val valid: BooleanArray?,
    val ret: IntArray
)

class Solution {
    fun countGoodNodes(edges: Array<IntArray>): Int {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        var result = 0
        val ret = IntArray(1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, -1, null, null, null, ret))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                val newL = IntArray(1)
                val newValid = booleanArrayOf(true)
                stk.addLast(Frame(4, -1, -1, -1, null, null, newValid, f.ret))
                stk.addLast(Frame(2, f.u, f.p, 0, null, newL, newValid, f.ret))
            } else if (f.step == 2) {
                if (f.i == adj[f.u].size) {
                    continue
                }
                stk.addLast(Frame(2, f.u, f.p, f.i + 1, null, f.l, f.valid, f.ret))
                val v = adj[f.u][f.i]
                if (v == f.p) {
                    continue
                }
                val newRet = IntArray(1)
                stk.addLast(Frame(3, -1, -1, -1, newRet, f.l, f.valid, f.ret))
                stk.addLast(Frame(1, v, f.u, -1, null, null, null, newRet))
            } else if (f.step == 3) {
                f.ret[0] += f.newRet!![0]
                f.l!![0] += 1
                if (f.newRet[0] * f.l[0] != f.ret[0]) {
                    f.valid!![0] = false
                }
            } else if (f.step == 4) {
                if (f.valid!![0]) {
                    ++result
                }
                f.ret[0] += 1
            }
        }
        return result
    }
}
