package maximumscoreafterapplyingoperationsonatree
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun maximumScoreAfterOperations(edges: Array<IntArray>, values: IntArray): Long {
        val adjacency = Array(values.size) { mutableListOf<Int>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1])
            adjacency[edge[1]].add(edge[0])
        }
        val dp = LongArray(values.size)
        val stack = ArrayDeque<Triple<Int, Int, Int>>()
        stack.addLast(Triple(1, 0, -1))
        while (stack.isNotEmpty()) {
            val (step, node, parent) = stack.removeLast()
            if (step == 1) {
                if (adjacency[node].size == if (node != 0) 1 else 0) {
                    dp[node] = values[node].toLong()
                    continue
                }
                stack.addLast(Triple(2, node, parent))
                for (neighbor in adjacency[node]) {
                    if (neighbor != parent) {
                        stack.addLast(Triple(1, neighbor, node))
                    }
                }
            } else {
                var total = 0L
                for (neighbor in adjacency[node]) {
                    if (neighbor != parent) {
                        total += dp[neighbor]
                    }
                }
                dp[node] = minOf(total, values[node].toLong())
            }
        }
        return values.sumOf { it.toLong() } - dp[0]
    }
}
