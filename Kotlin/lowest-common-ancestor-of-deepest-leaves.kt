package lowestcommonancestorofdeepestleaves

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        return lcaDeepestLeavesHelper(root).second
    }

    private fun lcaDeepestLeavesHelper(root: TreeNode?): Pair<Int, TreeNode?> {
        if (root == null) {
            return Pair(0, null)
        }
        val (d1, lca1) = lcaDeepestLeavesHelper(root.left)
        val (d2, lca2) = lcaDeepestLeavesHelper(root.right)
        if (d1 > d2) {
            return Pair(d1 + 1, lca1)
        }
        if (d1 < d2) {
            return Pair(d2 + 1, lca2)
        }
        return Pair(d1 + 1, root)
    }
}
