package heightofbinarytreeaftersubtreeremovalqueries

import common.TreeNode

// Time:  O(n)
// Space: O(n)
class Solution {
    fun treeQueries(root: TreeNode?, queries: IntArray): IntArray {
        val top = HashMap<Int, Pair<Int, Int>>()
        val depth = HashMap<Int, Int>()
        val height = HashMap<Int, Int>()
        val stack = ArrayDeque<Entry>()
        stack.addLast(Entry(1, root, 0))
        while (stack.isNotEmpty()) {
            val (step, curr, d) = stack.removeLast()
            if (step == 1) {
                if (curr == null) {
                    continue
                }
                stack.addLast(Entry(2, curr, d))
                stack.addLast(Entry(1, curr.right, d + 1))
                stack.addLast(Entry(1, curr.left, d + 1))
            } else if (step == 2) {
                val h = 1 + maxOf(
                    if (curr!!.left != null) height[curr.left!!.`val`] ?: 0 else 0,
                    if (curr.right != null) height[curr.right!!.`val`] ?: 0 else 0
                )
                val currentTop = top[d] ?: (0 to 0)
                if (h > currentTop.first) {
                    top[d] = h to currentTop.first
                } else if (h > currentTop.second) {
                    top[d] = currentTop.first to h
                }
                depth[curr.`val`] = d
                height[curr.`val`] = h
            }
        }
        return IntArray(queries.size) { i ->
            val q = queries[i]
            (depth[q]!! - 1) + if (height[q] != top[depth[q]]!!.first) {
                top[depth[q]]!!.first
            } else {
                top[depth[q]]!!.second
            }
        }
    }
}

private data class Entry(val step: Int, val curr: TreeNode?, val d: Int)
