package allnodesdistancekinbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(n)

class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode, k: Int): List<Int> {
        val neighbors = HashMap<Int, MutableList<Int>>()
        dfs(null, root, neighbors)

        var bfs = mutableListOf(target.`val`)
        val lookup = hashSetOf(target.`val`)
        for (i in 0 until k) {
            val curr = mutableListOf<Int>()
            for (node in bfs) {
                for (nei in neighbors[node] ?: emptyList<Int>()) {
                    if (!lookup.contains(nei)) {
                        curr.add(nei)
                        lookup.add(nei)
                    }
                }
            }
            bfs = curr
        }
        return bfs
    }

    private fun dfs(parent: TreeNode?, child: TreeNode?, neighbors: HashMap<Int, MutableList<Int>>) {
        if (child == null) {
            return
        }
        if (parent != null) {
            neighbors.getOrPut(parent.`val`) { mutableListOf() }.add(child.`val`)
            neighbors.getOrPut(child.`val`) { mutableListOf() }.add(parent.`val`)
        }
        dfs(child, child.left, neighbors)
        dfs(child, child.right, neighbors)
    }
}
