package verticalordertraversalofabinarytree
// Time:  O(nlogn)
// Space: O(n)

import common.TreeNode
import java.util.TreeMap

class Solution {
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val lookup = TreeMap<Int, TreeMap<Int, MutableList<Int>>>()
        dfs(root, lookup, 0, 0)
        val result = mutableListOf<List<Int>>()
        for (rows in lookup.values) {
            val report = mutableListOf<Int>()
            for (values in rows.values) {
                report.addAll(values.sorted())
            }
            result.add(report)
        }
        return result
    }

    private fun dfs(
        root: TreeNode?,
        lookup: TreeMap<Int, TreeMap<Int, MutableList<Int>>>,
        x: Int,
        y: Int
    ) {
        if (root == null) {
            return
        }
        lookup.getOrPut(x) { TreeMap() }
            .getOrPut(y) { mutableListOf() }
            .add(root.`val`)
        dfs(root.left, lookup, x - 1, y + 1)
        dfs(root.right, lookup, x + 1, y + 1)
    }
}
