package insufficientnodesinroottoleafpaths
// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun sufficientSubset(root: TreeNode?, limit: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.left == null && root.right == null) {
            return if (root.`val` < limit) null else root
        }
        root.left = sufficientSubset(root.left, limit - root.`val`)
        root.right = sufficientSubset(root.right, limit - root.`val`)
        if (root.left == null && root.right == null) {
            return null
        }
        return root
    }
}
