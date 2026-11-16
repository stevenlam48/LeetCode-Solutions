package findacorrespondingnodeofabinarytreeinacloneofthattree

import common.TreeNode

// Time:  O(n)
// Space: O(h)

class Solution {
    fun getTargetCopy(original: TreeNode?, cloned: TreeNode?, target: TreeNode?): TreeNode? {
        if (original == null) {
            return null
        }
        if (original === target) {
            return cloned
        }
        return getTargetCopy(original.left, cloned?.left, target)
            ?: getTargetCopy(original.right, cloned?.right, target)
    }
}
