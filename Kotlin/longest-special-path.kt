package longestspecialpath
// Time:  O(n + e)
// Space: O(n + e)

private data class Frame(
    val step: Int,
    val node: Int,
    val parent: Int,
    val depth: Int,
    val left: Int,
    val index: Int,
    val previousDepth: Int
)

class Solution {
    fun longestSpecialPath(edges: Array<IntArray>, nums: IntArray): IntArray {
        val adjacency = Array(nums.size) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1] to edge[2])
            adjacency[edge[1]].add(edge[0] to edge[2])
        }
        val result = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
        val lookup = HashMap<Int, Int>()
        val prefix = mutableListOf(0)
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, 0, -1, 0, -1, -1, -1))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            if (frame.step == 1) {
                val previousDepth = lookup.getOrDefault(nums[frame.node] - 1, -1)
                lookup[nums[frame.node] - 1] = frame.depth
                val left = maxOf(frame.left, previousDepth)
                val candidate0 = -(prefix[frame.depth] - prefix[left + 1])
                val candidate1 = frame.depth - left
                if (candidate0 < result[0] || candidate0 == result[0] && candidate1 < result[1]) {
                    result[0] = candidate0
                    result[1] = candidate1
                }
                stack.addLast(Frame(4, frame.node, -1, -1, -1, -1, previousDepth))
                stack.addLast(Frame(2, frame.node, frame.parent, frame.depth, left, 0, -1))
            } else if (frame.step == 2) {
                if (frame.index == adjacency[frame.node].size) {
                    continue
                }
                stack.addLast(
                    Frame(2, frame.node, frame.parent, frame.depth, frame.left, frame.index + 1, -1)
                )
                val (next, length) = adjacency[frame.node][frame.index]
                if (next == frame.parent) {
                    continue
                }
                prefix.add(prefix.last() + length)
                stack.addLast(Frame(3, -1, -1, -1, -1, -1, -1))
                stack.addLast(Frame(1, next, frame.node, frame.depth + 1, frame.left, -1, -1))
            } else if (frame.step == 3) {
                prefix.removeAt(prefix.lastIndex)
            } else if (frame.step == 4) {
                lookup[nums[frame.node] - 1] = frame.previousDepth
            }
        }
        return intArrayOf(-result[0], result[1])
    }
}
