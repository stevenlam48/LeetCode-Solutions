package treeofcoprimes

// Time:  O(50 * n) = O(n)
// Space: O(n)

class Solution {
    fun getCoprimes(nums: IntArray, edges: Array<IntArray>): IntArray {
        val adj = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            adj.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
            adj.getOrPut(edge[1]) { mutableListOf() }.add(edge[0])
        }
        val result = IntArray(nums.size) { -1 }
        val path = HashMap<Int, MutableList<Pair<Int, Int>>>()
        data class Frame(val step: Int, val prev: Int, val node: Int, val depth: Int)
        val stack = ArrayDeque<Frame>()
        stack.addLast(Frame(1, -1, 0, 0))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            when (frame.step) {
                1 -> {
                    stack.addLast(Frame(4, -1, frame.node, -1))
                    stack.addLast(Frame(3, frame.prev, frame.node, frame.depth))
                    stack.addLast(Frame(2, -1, frame.node, -1))
                }
                2 -> {
                    var maxDepth = -1
                    for ((x, nodes) in path) {
                        if (gcd(nums[frame.node], x) != 1) {
                            continue
                        }
                        if (nodes.last().second > maxDepth) {
                            maxDepth = nodes.last().second
                            result[frame.node] = nodes.last().first
                        }
                    }
                }
                3 -> {
                    path.getOrPut(nums[frame.node]) { mutableListOf() }.add(frame.node to frame.depth)
                    for (nei in adj[frame.node].orEmpty()) {
                        if (nei != frame.prev) {
                            stack.addLast(Frame(1, frame.node, nei, frame.depth + 1))
                        }
                    }
                }
                else -> {
                    val nodes = path[nums[frame.node]]!!
                    nodes.removeAt(nodes.lastIndex)
                    if (nodes.isEmpty()) {
                        path.remove(nums[frame.node])
                    }
                }
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
