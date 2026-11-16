package boundaryofbinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val nodes = mutableListOf<Int>()
        nodes.add(root.`val`)
        leftBoundary(root.left, nodes)
        leaves(root.left, nodes)
        leaves(root.right, nodes)
        rightBoundary(root.right, nodes)
        return nodes
    }

    private fun leftBoundary(root: TreeNode?, nodes: MutableList<Int>) {
        if (root == null || (root.left == null && root.right == null)) {
            return
        }
        nodes.add(root.`val`)
        if (root.left == null) {
            leftBoundary(root.right, nodes)
        } else {
            leftBoundary(root.left, nodes)
        }
    }

    private fun rightBoundary(root: TreeNode?, nodes: MutableList<Int>) {
        if (root == null || (root.right == null && root.left == null)) {
            return
        }
        if (root.right == null) {
            rightBoundary(root.left, nodes)
        } else {
            rightBoundary(root.right, nodes)
        }
        nodes.add(root.`val`)
    }

    private fun leaves(root: TreeNode?, nodes: MutableList<Int>) {
        if (root == null) {
            return
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.`val`)
            return
        }
        leaves(root.left, nodes)
        leaves(root.right, nodes)
    }
}
