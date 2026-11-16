package findduplicatesubtrees

import common.TreeNode

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode> {
        val trees = HashMap<Int, MutableList<TreeNode>>()
        val lookup = HashMap<Triple<Int, Int, Int>, Int>()
        getid(root, lookup, trees)

        val result = mutableListOf<TreeNode>()
        for (kvp in trees.values) {
            if (kvp.size > 1) {
                result.add(kvp[0])
            }
        }
        return result
    }

    private fun getid(
        root: TreeNode?,
        lookup: HashMap<Triple<Int, Int, Int>, Int>,
        trees: HashMap<Int, MutableList<TreeNode>>
    ): Int {
        var nodeId = 0
        if (root != null) {
            val data = Triple(
                root.`val`,
                getid(root.left, lookup, trees),
                getid(root.right, lookup, trees)
            )
            if (!lookup.containsKey(data)) {
                lookup[data] = lookup.size + 1
            }
            nodeId = lookup[data]!!
            trees.getOrPut(nodeId) { mutableListOf() }.add(root)
        }
        return nodeId
    }
}
