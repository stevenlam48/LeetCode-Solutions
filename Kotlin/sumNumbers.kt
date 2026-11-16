package sumNumbers

import common.TreeNode

// Time Complexity: O(n)
// Space Complexity: O(logn)

class Solution {
    fun dfs(root: TreeNode?, num0: Int): Int {
        if (root == null) {
            return 0
        }

        val num = num0 * 10 + root.`val`

        if (root.left == null && root.right == null) {
            return num
        }

        return dfs(root.left, num) + dfs(root.right, num)
    }

    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }
}
