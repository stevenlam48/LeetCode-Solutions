package treediameter
// Time:  O(|V| + |E|)
// Space: O(|E|)

class Solution {
    fun treeDiameter(edges: Array<IntArray>): Int {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        data class Box(var value: Int = 0)
        data class Frame(val step: Int, val u: Int, val p: Int, val child: Box?, val result: Box)
        var result = 0
        val rootResult = Box()
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, 0, -1, null, rootResult))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            if (frame.step == 1) {
                for (v in adj[frame.u]) {
                    if (v == frame.p) {
                        continue
                    }
                    val child = Box()
                    stack.addLast(Frame(2, -2, -2, child, frame.result))
                    stack.addLast(Frame(1, v, frame.u, null, child))
                }
            } else {
                result = maxOf(result, frame.result.value + frame.child!!.value + 1)
                frame.result.value = maxOf(frame.result.value, frame.child.value + 1)
            }
        }
        return result
    }
}
