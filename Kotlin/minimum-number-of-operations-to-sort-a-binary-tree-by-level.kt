package minimumnumberofoperationstosortabinarytreebylevel

// Time:  O(nlogn)
// Space: O(w)

import common.TreeNode

class Solution {
    fun minimumOperations(root: TreeNode?): Int {
        var result = 0
        var q = listOf(root!!)
        while (q.isNotEmpty()) {
            val newQ = ArrayList<TreeNode>()
            for (node in q) {
                if (node.left != null) {
                    newQ.add(node.left!!)
                }
                if (node.right != null) {
                    newQ.add(node.right!!)
                }
            }
            val idx = q.indices.sortedWith(compareBy { q[it].`val` }).toIntArray()
            for (i in idx.indices) {
                while (idx[i] != i) {
                    val j = idx[i]
                    val tmp = idx[j]
                    idx[j] = idx[i]
                    idx[i] = tmp
                    ++result
                }
            }
            q = newQ
        }
        return result
    }
}
