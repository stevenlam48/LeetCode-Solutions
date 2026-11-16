package deleteleaveswithagivenvalue

// Time:  O(n)
// Space: O(h)
import common.TreeNode

class Solution {
    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        if (root == null) return null
        root.left = removeLeafNodes(root.left, target)
        root.right = removeLeafNodes(root.right, target)
        return if (root.left == root.right && root.`val` == target) null else root
    }
}
