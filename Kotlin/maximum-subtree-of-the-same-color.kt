package maximumsubtreeofthesamecolor
// Time:  O(n)
// Space: O(h)

class Solution {
    private data class Frame(
        val step: Int,
        val u: Int,
        val p: Int,
        val i: Int,
        val newRet: IntArray?,
        val ret: IntArray
    )

    fun maximumSubtreeSize(edges: Array<IntArray>, colors: IntArray): Int {
        val adj = Array(colors.size) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        var result = 0
        val ret = intArrayOf(1)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, 0, -1, -1, null, ret))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            when (frame.step) {
                1 -> {
                    stk.addLast(Frame(4, -1, -1, -1, null, frame.ret))
                    stk.addLast(Frame(2, frame.u, frame.p, 0, null, frame.ret))
                }
                2 -> {
                    if (frame.i == adj[frame.u].size) {
                        continue
                    }
                    val v = adj[frame.u][frame.i]
                    stk.addLast(Frame(2, frame.u, frame.p, frame.i + 1, null, frame.ret))
                    if (v == frame.p) {
                        continue
                    }
                    val newRet = intArrayOf(1)
                    stk.addLast(Frame(3, frame.u, frame.p, frame.i, newRet, frame.ret))
                    stk.addLast(Frame(1, v, frame.u, -1, null, newRet))
                }
                3 -> {
                    val v = adj[frame.u][frame.i]
                    if (frame.ret[0] == -1) {
                        continue
                    }
                    if (frame.newRet!![0] == -1 || colors[v] != colors[frame.u]) {
                        frame.ret[0] = -1
                        continue
                    }
                    frame.ret[0] += frame.newRet[0]
                }
                4 -> result = maxOf(result, frame.ret[0])
            }
        }
        return result
    }
}
