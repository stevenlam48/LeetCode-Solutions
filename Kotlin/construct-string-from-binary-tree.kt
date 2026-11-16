package constructstringfrombinarytree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun tree2str(t: TreeNode?): String {
        if (t == null) {
            return ""
        }

        var s = t.`val`.toString()

        if (t.left != null || t.right != null) {
            s += "(" + tree2str(t.left) + ")"
        }

        if (t.right != null) {
            s += "(" + tree2str(t.right) + ")"
        }

        return s
    }
}
