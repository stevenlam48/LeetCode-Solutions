package subtreeinversionsum

// Time:  O(n)
// Space: O(n)
private data class Frame(
    val step: Int,
    val u: Int,
    val p: Int,
    val i: Int,
    val newRet: LongArray?,
    val ret: LongArray
)

class Solution {
    fun subtreeInversionSum(edges: Array<IntArray>, nums: IntArray, k: Int): Long {
        val adj = Array(nums.size) { mutableListOf<Int>() }
        val dp = ArrayDeque<LongArray>()
        fun iterDfs(): Long {
            val ret = LongArray(3)
            val stk = ArrayDeque<Frame>()
            stk.addLast(Frame(1, 0, -1, -1, null, ret))
            while (stk.isNotEmpty()) {
                val frame = stk.removeLast()
                if (frame.step == 1) {
                    dp.addLast(LongArray(2))
                    frame.ret[0] = nums[frame.u].toLong()
                    frame.ret[1] = 0
                    frame.ret[2] = 0
                    stk.addLast(Frame(4, frame.u, frame.p, -1, null, frame.ret))
                    stk.addLast(Frame(2, frame.u, frame.p, 0, null, frame.ret))
                } else if (frame.step == 2) {
                    if (frame.i == adj[frame.u].size) {
                        continue
                    }
                    val v = adj[frame.u][frame.i]
                    stk.addLast(Frame(2, frame.u, frame.p, frame.i + 1, null, frame.ret))
                    if (v == frame.p) {
                        continue
                    }
                    val newRet = LongArray(3)
                    stk.addLast(Frame(3, frame.u, frame.p, frame.i, newRet, frame.ret))
                    stk.addLast(Frame(1, v, frame.u, -1, null, newRet))
                } else if (frame.step == 3) {
                    val newRet = frame.newRet!!
                    frame.ret[0] += newRet[0]
                    frame.ret[1] += newRet[1]
                    frame.ret[2] += newRet[2]
                } else {
                    frame.ret[1] = maxOf(frame.ret[1], dp.last()[1] - 2 * frame.ret[0])
                    frame.ret[2] = maxOf(frame.ret[2], dp.last()[0] + 2 * frame.ret[0])
                    dp.removeLast()
                    if (dp.size >= k) {
                        dp[dp.size - k][0] += frame.ret[1]
                        dp[dp.size - k][1] += frame.ret[2]
                    }
                }
            }
            return ret[0] + ret[1]
        }

        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        return iterDfs()
    }
}
