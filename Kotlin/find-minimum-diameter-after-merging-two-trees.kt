package findminimumdiameteraftermergingtwotrees

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    private class Ret(var value: Int = 0)

    private class Frame(
        val step: Int,
        val u: Int,
        val p: Int,
        val ret2: Ret?,
        val ret: Ret
    )

    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        val d1 = treeDiameter(edges1)
        val d2 = treeDiameter(edges2)
        return maxOf(ceilDivide(d1, 2) + 1 + ceilDivide(d2, 2), d1, d2)
    }

    private fun ceilDivide(a: Int, b: Int): Int = (a + b - 1) / b

    private fun treeDiameter(edges: Array<IntArray>): Int {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        var result = 0
        val rootRet = Ret()
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, null, rootRet))
        while (stk.isNotEmpty()) {
            val f = stk.removeLast()
            if (f.step == 1) {
                for (v in adj[f.u]) {
                    if (v == f.p) {
                        continue
                    }
                    val ret2 = Ret()
                    stk.addLast(Frame(2, -2, -2, ret2, f.ret))
                    stk.addLast(Frame(1, v, f.u, null, ret2))
                }
            } else if (f.step == 2) {
                result = maxOf(result, f.ret.value + (f.ret2!!.value + 1))
                f.ret.value = maxOf(f.ret.value, f.ret2.value + 1)
            }
        }
        return result
    }
}
