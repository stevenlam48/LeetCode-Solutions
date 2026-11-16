package maximumdistinctpathsuminabinarytree
// Time:  O(n^2)
// Space: O(n)

import common.TreeNode

class Solution {
    fun maxSum(root: TreeNode?): Int {
        val adj = arrayListOf(mutableListOf<Int>())
        val first = root!!
        val vals = arrayListOf(first.`val`)
        var queue = mutableListOf(first to 0)
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Pair<TreeNode, Int>>()
            for ((u, p) in queue) {
                vals.add(u.`val`)
                adj.add(mutableListOf())
                val i = adj.size - 1
                if (p != -1) {
                    adj[i].add(p)
                    adj[p].add(i)
                }
                for (node in listOf(u.left, u.right)) {
                    if (node == null) {
                        continue
                    }
                    newQueue.add(node to i)
                }
            }
            queue = newQueue
        }

        fun iterativeDfs(start: Int): Int {
            var result = Int.MIN_VALUE
            var total = 0
            val lookup = hashSetOf<Int>()
            val stack = ArrayDeque<Triple<Int, Int, Int>>()
            stack.addLast(Triple(1, start, -1))
            while (stack.isNotEmpty()) {
                val (step, u, p) = stack.removeLast()
                if (step == 1) {
                    if (vals[u] in lookup) {
                        continue
                    }
                    stack.addLast(Triple(2, u, p))
                    lookup.add(vals[u])
                    total += vals[u]
                    result = maxOf(result, total)
                    for (v in adj[u]) {
                        if (v == p) {
                            continue
                        }
                        stack.addLast(Triple(1, v, u))
                    }
                } else if (step == 2) {
                    total -= vals[u]
                    lookup.remove(vals[u])
                }
            }
            return result
        }

        var result = Int.MIN_VALUE
        for (u in adj.indices) {
            result = maxOf(result, iterativeDfs(u))
        }
        return result
    }
}
