package connect
// Time Complexity: O(n)
// Space Complexity: O(1)

class TreeLinkNode(var `val`: Int) {
    var left: TreeLinkNode? = null
    var right: TreeLinkNode? = null
    var next: TreeLinkNode? = null
}

class Solution {
    fun connect(root: TreeLinkNode?) {
        var level = root
        while (level != null) {
            var list: TreeLinkNode? = null
            var first: TreeLinkNode? = null
            var current = level
            while (current != null) {
                if (first == null) {
                    first = current.left ?: current.right
                }
                current.left?.let {
                    list?.next = it
                    list = it
                }
                current.right?.let {
                    list?.next = it
                    list = it
                }
                current = current.next
            }
            level = first
        }
    }
}
