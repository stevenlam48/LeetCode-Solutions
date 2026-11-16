package invertbinarytree

import common.TreeNode
import java.util.ArrayDeque

// Time:  O(n)
// Space: O(h)

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root != null) {
            val nodes = ArrayDeque<TreeNode>()
            nodes.addLast(root)
            while (nodes.isNotEmpty()) {
                val node = nodes.removeFirst()
                val tmp = node.left
                node.left = node.right
                node.right = tmp
                if (node.left != null) {
                    nodes.addLast(node.left!!)
                }
                if (node.right != null) {
                    nodes.addLast(node.right!!)
                }
            }
        }
        return root
    }
}
