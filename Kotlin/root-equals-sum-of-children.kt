package rootequalssumofchildren

import common.TreeNode

// Time:  O(1)
// Space: O(1)

// tree
class Solution {
    fun checkTree(root: TreeNode?): Boolean {
        val node = root!!
        return node.`val` == node.left!!.`val` + node.right!!.`val`
    }
}
