package deletenodeinabst

// Time:  O(h)
// Space: O(h)
import common.TreeNode

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` > key) {
            root.left = deleteNode(root.left, key)
        } else if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
        } else {
            if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            } else {
                var successor = root.right!!
                while (successor.left != null) successor = successor.left!!
                root.`val` = successor.`val`
                root.right = deleteNode(root.right, successor.`val`)
            }
        }
        return root
    }
}
