package extractkthcharacterfromtheropetree

// Time:  O(h)
// Space: O(1)

class Solution {
    fun getKthCharacter(root: RopeTreeNode, k: Int): Char {
        var node = root
        var remaining = k
        while (node.len != 0) {
            val l = if (node.left != null) {
                maxOf(node.left!!.len, node.left!!.`val`.length)
            } else {
                0
            }
            if (remaining <= l) {
                node = node.left!!
            } else {
                remaining -= l
                node = node.right!!
            }
        }
        return node.`val`[remaining - 1]
    }
}

class RopeTreeNode(var len: Int = 0, var `val`: String = "") {
    var left: RopeTreeNode? = null
    var right: RopeTreeNode? = null
}
