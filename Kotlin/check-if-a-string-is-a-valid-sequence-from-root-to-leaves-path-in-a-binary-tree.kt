package checkifastringisavalidsequencefromroottoleavespathinabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(w)

class Solution {
    fun isValidSequence(root: TreeNode?, arr: IntArray): Boolean {
        var q = mutableListOf<TreeNode?>(root)
        for (depth in arr.indices) {
            val newQ = mutableListOf<TreeNode?>()
            while (q.isNotEmpty()) {
                val node = q.removeAt(q.size - 1)
                if (node == null || node.`val` != arr[depth]) {
                    continue
                }
                if (depth + 1 == arr.size && node.left === node.right) {
                    return true
                }
                newQ.add(node.left)
                newQ.add(node.right)
            }
            q = newQ
        }
        return false
    }
}
