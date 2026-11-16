package inordersuccessorinbstii
// Time:  O(h)
// Space: O(1)

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

class Solution {
    fun inorderSuccessor(node: Node?): Node? {
        var current = node ?: return null
        if (current.right != null) {
            current = current.right!!
            while (current.left != null) {
                current = current.left!!
            }
            return current
        }
        while (current.parent != null && current.parent!!.right === current) {
            current = current.parent!!
        }
        return current.parent
    }
}
