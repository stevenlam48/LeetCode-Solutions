package changetherootofabinarytree

// Time:  O(h)
// Space: O(1)

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

class Solution {
    fun flipBinaryTree(root: Node?, leaf: Node?): Node? {
        var curr = leaf
        var parent: Node? = null
        while (true) {
            val child = curr!!.parent
            curr.parent = parent
            if (curr.left == parent) {
                curr.left = null
            } else {
                curr.right = null
            }
            if (curr == root) {
                break
            }
            if (curr.left != null) {
                curr.right = curr.left
            }
            curr.left = child
            parent = curr
            curr = child
        }
        return leaf
    }
}
