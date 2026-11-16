package findnumberofcoinstoplaceintreenodes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun placedCoins(edges: Array<IntArray>, cost: IntArray): LongArray {
        val adj = MutableList(cost.size) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val result = LongArray(cost.size)
        data class Frame(
            val step: Int,
            val u: Int,
            val p: Int,
            val i: Int,
            val newRet: MutableList<Long>?,
            val ret: MutableList<Long>
        )

        val ret = mutableListOf(cost[0].toLong())
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, -1, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            if (frame.step == 1) {
                stk.addLast(Frame(4, frame.u, -1, -1, null, frame.ret))
                stk.addLast(Frame(2, frame.u, frame.p, 0, null, frame.ret))
            } else if (frame.step == 2) {
                if (frame.i == adj[frame.u].size) {
                    continue
                }
                val v = adj[frame.u][frame.i]
                stk.addLast(Frame(2, frame.u, frame.p, frame.i + 1, frame.newRet, frame.ret))
                if (v == frame.p) {
                    continue
                }
                val newRet = mutableListOf(cost[v].toLong())
                stk.addLast(Frame(3, -1, -1, -1, newRet, frame.ret))
                stk.addLast(Frame(1, v, frame.u, -1, null, newRet))
            } else if (frame.step == 3) {
                for (c in frame.newRet!!) {
                    frame.ret.add(c)
                }
                frame.ret.sort()
                if (frame.ret.size > 5) {
                    val values = listOf(
                        frame.ret[0],
                        frame.ret[1],
                        frame.ret[frame.ret.size - 3],
                        frame.ret[frame.ret.size - 2],
                        frame.ret[frame.ret.size - 1]
                    )
                    frame.ret.clear()
                    frame.ret.addAll(values)
                }
            } else if (frame.step == 4) {
                result[frame.u] = if (frame.ret.size < 3) {
                    1L
                } else {
                    maxOf(
                        frame.ret[0] * frame.ret[1] * frame.ret[frame.ret.size - 1],
                        frame.ret[frame.ret.size - 3] * frame.ret[frame.ret.size - 2] * frame.ret[frame.ret.size - 1],
                        0L
                    )
                }
            }
        }
        return result
    }
}
