package convertbinarysearchtreetosorteddoublylinkedlist
// Time:  O(n)
// Space: O(h)

class Node(var `val`: Int, var left: Node? = null, var right: Node? = null)

class Solution {
    fun treeToDoublyList(root: Node?): Node? {
        if (root == null) {
            return null
        }
        var leftHead = root
        var leftTail = root
        var rightHead = root
        var rightTail = root
        if (root.left != null) {
            leftHead = treeToDoublyList(root.left)!!
            leftTail = leftHead.left!!
        }
        if (root.right != null) {
            rightHead = treeToDoublyList(root.right)!!
            rightTail = rightHead.left!!
        }
        leftTail.right = root
        rightHead.left = root
        root.left = leftTail
        root.right = rightHead
        leftHead.left = rightTail
        rightTail.right = leftHead
        return leftHead
    }
}
