package copylistwithrandompointer

// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    fun copyRandomList(head: Node?): Node? {
        var curr = head
        while (curr != null) {
            val node = Node(curr.`val`)
            node.next = curr.next
            curr.next = node
            curr = node.next
        }

        curr = head
        while (curr != null) {
            curr.next?.random = curr.random?.next
            curr = curr.next?.next
        }

        val dummy = Node(0)
        var copyCurr: Node? = dummy
        curr = head
        while (curr != null) {
            copyCurr!!.next = curr.next
            curr.next = curr.next?.next
            copyCurr = copyCurr.next
            curr = curr.next
        }

        return dummy.next
    }
}
