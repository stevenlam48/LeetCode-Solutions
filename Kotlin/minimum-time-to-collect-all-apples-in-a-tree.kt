package minimumtimetocollectallapplesinatree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: BooleanArray): Int {
        val graph = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            graph.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            graph.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }

        class Frame(
            val step: Int,
            val par: Int,
            val node: Int,
            val newRet: IntArray?,
            val ret: IntArray
        )

        val result = intArrayOf(0, 0)
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(1, -1, 0, null, result))
        while (stk.isNotEmpty()) {
            val frame = stk.removeLast()
            if (frame.step == 1) {
                frame.ret[1] = if (hasApple[frame.node]) 1 else 0
                for (nei in graph[frame.node] ?: emptyList()) {
                    if (nei == frame.par) {
                        continue
                    }
                    val newRet = intArrayOf(0, 0)
                    stk.addLast(Frame(2, -1, -1, newRet, frame.ret))
                    stk.addLast(Frame(1, frame.node, nei, null, newRet))
                }
            } else {
                val newRet = frame.newRet!!
                frame.ret[0] += newRet[0] + newRet[1]
                if (newRet[0] + newRet[1] != 0) {
                    frame.ret[1] = 1
                }
            }
        }
        return 2 * result[0]
    }
}
