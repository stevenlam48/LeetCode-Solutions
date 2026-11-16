package inordersuccessorinbst
// Time:  O(h)
// Space: O(1)

import common.TreeNode

class Solution {
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        var current = p
        if (current?.right != null) {
            current = current.right
            while (current?.left != null) {
                current = current.left
            }
            return current
        }

        var node = root
        var successor: TreeNode? = null
        while (node != null && node !== p) {
            if (node.`val` > p!!.`val`) {
                successor = node
                node = node.left
            } else {
                node = node.right
            }
        }
        return successor
    }
}
