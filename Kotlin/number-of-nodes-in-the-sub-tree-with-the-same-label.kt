package numberofnodesinthesubtreewiththesamelabel
// Time:  O(n)
// Space: O(h)

class Solution {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        val result = IntArray(n)
        iterDfs(labels, adj, 0, -1, result)
        return result
    }

    private data class Frame(
        val step: Int,
        val node: Int,
        val parent: Int,
        val index: Int,
        val childCounts: IntArray?,
        val counts: IntArray
    )

    private fun iterDfs(
        labels: String,
        adj: Array<MutableList<Int>>,
        node: Int,
        parent: Int,
        result: IntArray
    ) {
        val ret = IntArray(26)
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, node, -1, -1, null, ret))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            when (frame.step) {
                1 -> {
                    stack.addLast(Frame(4, frame.node, -1, -1, null, frame.counts))
                    stack.addLast(Frame(2, frame.node, frame.parent, adj[frame.node].size - 1, null, frame.counts))
                }
                2 -> {
                    if (frame.index < 0 || adj[frame.node][frame.index] == frame.parent) {
                        continue
                    }
                    val childCounts = IntArray(26)
                    stack.addLast(Frame(2, frame.node, frame.parent, frame.index - 1, null, frame.counts))
                    stack.addLast(Frame(3, -1, -1, -1, childCounts, frame.counts))
                    stack.addLast(Frame(1, adj[frame.node][frame.index], frame.node, -1, null, childCounts))
                }
                3 -> {
                    val childCounts = frame.childCounts!!
                    for (k in childCounts.indices) {
                        frame.counts[k] += childCounts[k]
                    }
                }
                else -> {
                    val labelIndex = labels[frame.node] - 'a'
                    frame.counts[labelIndex]++
                    result[frame.node] = frame.counts[labelIndex]
                }
            }
        }
    }
}
