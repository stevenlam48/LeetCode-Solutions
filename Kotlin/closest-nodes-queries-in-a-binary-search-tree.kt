package closestnodesqueriesinabinarysearchtree

// Time:  O(n + qlogn)
// Space: O(n)

import common.TreeNode

class Solution {
    fun closestNodes(root: TreeNode?, queries: IntArray): Array<IntArray> {
        val inorder = ArrayList<Int>()
        val stk = mutableListOf<Pair<Int, TreeNode?>>(1 to root)
        while (stk.isNotEmpty()) {
            val (step, node) = stk.removeAt(stk.lastIndex)
            if (step == 1) {
                if (node == null) {
                    continue
                }
                stk.add(1 to node.right)
                stk.add(2 to node)
                stk.add(1 to node.left)
            } else if (step == 2) {
                inorder.add(node!!.`val`)
            }
        }
        val result = ArrayList<IntArray>()
        for (q in queries) {
            var left = 0
            var right = inorder.size
            while (left < right) {
                val mid = left + (right - left) / 2
                if (inorder[mid] < q) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            if (left == inorder.size) {
                result.add(intArrayOf(inorder[left - 1], -1))
            } else if (inorder[left] == q) {
                result.add(intArrayOf(inorder[left], inorder[left]))
            } else if (left == 0) {
                result.add(intArrayOf(-1, inorder[left]))
            } else {
                result.add(intArrayOf(inorder[left - 1], inorder[left]))
            }
        }
        return result.toTypedArray()
    }
}
