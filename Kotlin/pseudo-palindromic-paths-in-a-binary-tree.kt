package pseudopalindromicpathsinabinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun pseudoPalindromicPaths(root: TreeNode?): Int {
        var result = 0
        val stk = ArrayDeque<Pair<TreeNode?, Int>>()
        stk.add(Pair(root, 0))
        while (stk.isNotEmpty()) {
            val (node, prevCount) = stk.removeLast()
            if (node == null) {
                continue
            }
            val count = prevCount xor (1 shl node.`val`)
            if (node.left == null && node.right == null && (count and (count - 1)) == 0) {
                ++result
            }
            stk.add(Pair(node.right, count))
            stk.add(Pair(node.left, count))
        }
        return result
    }
}
