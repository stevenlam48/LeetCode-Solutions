package constructbinarysearchtreefrompreordertraversal

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    private var index = 0

    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        index = 0
        return bstFromPreorderHelper(preorder, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun bstFromPreorderHelper(preorder: IntArray, left: Int, right: Int): TreeNode? {
        if (index == preorder.size ||
            preorder[index] < left ||
            preorder[index] > right
        ) {
            return null
        }

        val root = TreeNode(preorder[index++])
        root.left = bstFromPreorderHelper(preorder, left, root.`val`)
        root.right = bstFromPreorderHelper(preorder, root.`val`, right)
        return root
    }
}
