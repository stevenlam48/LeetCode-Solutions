package sumofroottoleafbinarynumbers

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun sumRootToLeaf(root: TreeNode?): Int {
        return sumRootToLeafHelper(root, 0)
    }

    private fun sumRootToLeafHelper(root: TreeNode?, value: Int): Int {
        val mod = 1_000_000_007
        if (root == null) {
            return 0
        }
        val current = (value * 2 + root.`val`) % mod
        if (root.left == null && root.right == null) {
            return current
        }
        return (sumRootToLeafHelper(root.left, current) +
            sumRootToLeafHelper(root.right, current)) % mod
    }
}
