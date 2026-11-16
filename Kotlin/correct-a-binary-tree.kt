package correctabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(w)

class Solution {
    fun correctBinaryTree(root: TreeNode?): TreeNode? {
        var q = HashMap<TreeNode, TreeNode?>()
        if (root != null) {
            q[root] = null
        }
        while (q.isNotEmpty()) {
            val newQ = HashMap<TreeNode, TreeNode?>()
            for ((node, parent) in q) {
                if (node.right != null && q.containsKey(node.right)) {
                    if (parent != null) {
                        if (parent.left === node) {
                            parent.left = null
                        } else {
                            parent.right = null
                        }
                    }
                    return root
                }
                node.left?.let { newQ[it] = node }
                node.right?.let { newQ[it] = node }
            }
            q = newQ
        }
        return null
    }
}
