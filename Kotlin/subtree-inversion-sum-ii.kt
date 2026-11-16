package subtreeinversionsumii

// Time:  O(n * k)
// Space: O(n + h * k)
private class ReturnState(var value: Array<LongArray> = emptyArray())

private data class Frame(
    val step: Int,
    val u: Int,
    val p: Int,
    val i: Int,
    val newRet: ReturnState?,
    val ret: ReturnState
)

class Solution {
    fun subtreeInversionSum(edges: Array<IntArray>, nums: IntArray, k: Int): Int {
        val adj = Array(nums.size) { mutableListOf<Int>() }
        fun iterDfs(): Int {
            val result = ReturnState()
            val stk = ArrayDeque<Frame>()
            stk.addLast(Frame(1, 0, -1, -1, null, result))
            while (stk.isNotEmpty()) {
                val frame = stk.removeLast()
                if (frame.step == 1) {
                    frame.ret.value = Array(2) { LongArray(k) { nums[frame.u].toLong() } }
                    stk.addLast(Frame(4, -1, -1, -1, null, frame.ret))
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
                    val newRet = ReturnState()
                    stk.addLast(Frame(3, -1, -1, -1, newRet, frame.ret))
                    stk.addLast(Frame(1, v, frame.u, -1, null, newRet))
                } else if (frame.step == 3) {
                    val newDp1 = frame.newRet!!.value[0]
                    val newDp2 = frame.newRet.value[1]
                    val dp1 = frame.ret.value[0]
                    val dp2 = frame.ret.value[1]
                    for (i in 0 until k / 2) {
                        dp1[i] = maxOf(dp1[i] + newDp1[(k - 2) - i], dp1[(k - 2) - i] + newDp1[i])
                        dp2[i] = minOf(dp2[i] + newDp2[(k - 2) - i], dp2[(k - 2) - i] + newDp2[i])
                    }
                    for (i in k / 2 until k) {
                        dp1[i] += newDp1[i]
                        dp2[i] += newDp2[i]
                    }
                    for (i in k - 2 downTo 0) {
                        dp1[i] = maxOf(dp1[i], dp1[i + 1])
                        dp2[i] = minOf(dp2[i], dp2[i + 1])
                    }
                } else {
                    val dp1 = frame.ret.value[0]
                    val dp2 = frame.ret.value[1]
                    val mx = maxOf(dp1[0], -dp2[k - 1])
                    val mn = minOf(dp2[0], -dp1[k - 1])
                    for (i in k - 1 downTo 1) {
                        dp1[i] = dp1[i - 1]
                        dp2[i] = dp2[i - 1]
                    }
                    dp1[0] = mx
                    dp2[0] = mn
                }
            }
            return result.value[0][0].toInt()
        }

        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        return iterDfs()
    }
}
