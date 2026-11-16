package closestleafinabinarytree

// Time:  O(n)
// Space: O(n)

import common.TreeNode

class Solution {
    fun findClosestLeaf(root: TreeNode?, k: Int): Int {
        val neighbors = HashMap<Int, MutableList<Int>>()
        val leaves = HashSet<Int>()
        traverse(root, neighbors, leaves)
        var q = mutableListOf(k)
        val lookup = hashSetOf(k)
        while (q.isNotEmpty()) {
            val nextQ = mutableListOf<Int>()
            for (u in q) {
                if (leaves.contains(u)) {
                    return u
                }
                for (v in neighbors[u].orEmpty()) {
                    if (lookup.contains(v)) {
                        continue
                    }
                    lookup.add(v)
                    nextQ.add(v)
                }
            }
            q = nextQ
        }
        return 0
    }

    private fun traverse(
        node: TreeNode?,
        neighbors: HashMap<Int, MutableList<Int>>,
        leaves: HashSet<Int>
    ) {
        if (node == null) {
            return
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.`val`)
            return
        }
        val left = node.left
        if (left != null) {
            neighbors.getOrPut(node.`val`) { mutableListOf() }.add(left.`val`)
            neighbors.getOrPut(left.`val`) { mutableListOf() }.add(node.`val`)
            traverse(left, neighbors, leaves)
        }
        val right = node.right
        if (right != null) {
            neighbors.getOrPut(node.`val`) { mutableListOf() }.add(right.`val`)
            neighbors.getOrPut(right.`val`) { mutableListOf() }.add(node.`val`)
            traverse(right, neighbors, leaves)
        }
    }
}
