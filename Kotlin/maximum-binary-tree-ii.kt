package maximumbinarytreeii

import common.TreeNode

// Time:  O(h)
// Space: O(1)

class Solution {
    fun insertIntoMaxTree(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) {
            return TreeNode(value)
        }

        if (value > root.`val`) {
            val node = TreeNode(value)
            node.left = root
            return node
        }

        var curr: TreeNode = root
        while (curr.right != null && curr.right!!.`val` > value) {
            curr = curr.right!!
        }
        val node = TreeNode(value)
        node.left = curr.right
        curr.right = node
        return root
    }
}
