package lowestcommonancestorofabinarytreeiii

// Time:  O(h)
// Space: O(1)

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

class Solution {
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var a = p
        var b = q
        while (a !== b) {
            a = if (a != null) a.parent else q
            b = if (b != null) b.parent else p
        }
        return a
    }
}
