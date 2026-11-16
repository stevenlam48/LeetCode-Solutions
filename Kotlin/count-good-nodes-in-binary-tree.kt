package countgoodnodesinbinarytree

// Time:  O(n)
// Space: O(h)

import common.TreeNode

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var result = 0
        val stk = mutableListOf<Pair<TreeNode?, Int>>(Pair(root, root!!.`val`))
        while (stk.isNotEmpty()) {
            var (node, currMax) = stk.removeAt(stk.lastIndex)
            if (node == null) {
                continue
            }
            currMax = maxOf(currMax, node.`val`)
            result += if (currMax <= node.`val`) 1 else 0
            stk.add(Pair(node.right, currMax))
            stk.add(Pair(node.left, currMax))
        }
        return result
    }
}
