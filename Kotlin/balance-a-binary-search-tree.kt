package balanceabinarysearchtree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun balanceBST(root: TreeNode?): TreeNode? {
        return sortedArrayToBst(inorderTraversal(root))
    }

    private data class Frame(val i: Int, val j: Int, val ret: (TreeNode) -> Unit)

    private fun sortedArrayToBst(arr: List<Int>): TreeNode? {
        var result: TreeNode? = null
        val stk = ArrayDeque<Frame>()
        stk.addLast(Frame(0, arr.size) { result = it })
        while (stk.isNotEmpty()) {
            val (i, j, ret) = stk.removeLast()
            if (i >= j) {
                continue
            }
            val mid = i + (j - i) / 2
            val node = TreeNode(arr[mid])
            ret(node)
            stk.addLast(Frame(mid + 1, j) { node.right = it })
            stk.addLast(Frame(i, mid) { node.left = it })
        }
        return result
    }

    private fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stk = ArrayDeque<Pair<TreeNode?, Boolean>>()
        stk.addLast(Pair(root, false))
        while (stk.isNotEmpty()) {
            val (node, visited) = stk.removeLast()
            if (node == null) {
                continue
            }
            if (visited) {
                result.add(node.`val`)
            } else {
                stk.addLast(Pair(node.right, false))
                stk.addLast(Pair(node, true))
                stk.addLast(Pair(node.left, false))
            }
        }
        return result
    }
}
