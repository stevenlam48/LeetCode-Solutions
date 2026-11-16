package maximumpathqualityofagraph
// Time:  O(|V| + |E| + 4^(maxTime/min(times))) = O(|V| + |E| + 4^10)
// Space: O(|V| + |E|)

class Solution {
    fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {
        val adj = Array(values.size) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1] to edge[2])
            adj[edge[1]].add(edge[0] to edge[2])
        }
        return iterDfs(values, adj, maxTime)
    }

    private fun iterDfs(values: IntArray, adj: Array<MutableList<Pair<Int, Int>>>, maxTime: Int): Int {
        val lookup = IntArray(values.size)
        val lookup2 = Array(values.size) { hashSetOf<Int>() }
        var result = 0
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, 0, -1, maxTime, 0))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            val step = frame.step
            val u = frame.u
            val v = frame.v
            val time = frame.time
            var total = frame.total
            if (step == 1) {
                if (++lookup[u] == 1) {
                    total += values[u]
                }
                if (u == 0) {
                    result = maxOf(result, total)
                }
                stack.addLast(Frame(4, u, -1, -1, -1))
                for ((next, t) in adj[u]) {
                    if (lookup2[u].contains(next) || time < t) {
                        continue
                    }
                    stack.addLast(Frame(3, u, next, -1, -1))
                    stack.addLast(Frame(1, next, -1, time - t, total))
                    stack.addLast(Frame(2, u, next, -1, -1))
                }
            } else if (step == 2) {
                lookup2[u].add(v)
            } else if (step == 3) {
                lookup2[u].remove(v)
            } else if (step == 4) {
                --lookup[u]
            }
        }
        return result
    }

    private data class Frame(val step: Int, val u: Int, val v: Int, val time: Int, val total: Int)
}
