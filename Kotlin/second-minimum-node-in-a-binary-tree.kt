package secondminimumnodeinabinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode
import java.util.TreeSet

class Solution {
    fun findSecondMinimumValue(root: TreeNode?): Int {
        val bst = TreeSet<Int>()
        findSecondMinimumValueHelper(root, bst)
        return if (bst.size < 2) -1 else bst.last()
    }

    private fun findSecondMinimumValueHelper(root: TreeNode?, bst: TreeSet<Int>) {
        if (root == null) {
            return
        }
        bst.add(root.`val`)
        if (bst.size > 2) {
            bst.pollLast()
        }
        findSecondMinimumValueHelper(root.left, bst)
        findSecondMinimumValueHelper(root.right, bst)
    }
}
