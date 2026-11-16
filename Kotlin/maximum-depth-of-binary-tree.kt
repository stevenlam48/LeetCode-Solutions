package maximumdepthofbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}
