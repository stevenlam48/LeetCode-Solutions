package hasPathSum

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null) {
            return sum == root.`val`
        }
        return hasPathSum(root.left, sum - root.`val`) ||
            hasPathSum(root.right, sum - root.`val`)
    }
}
