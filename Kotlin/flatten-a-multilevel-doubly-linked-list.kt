package flattenamultileveldoublylinkedlist

// Time:  O(n)
// Space: O(1)

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

class Solution {
    fun flatten(head: Node?): Node? {
        var curr = head
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next
                continue
            }
            val currNext = curr.next
            curr.child!!.prev = curr
            curr.next = curr.child
            var lastChild = curr
            while (lastChild!!.next != null) {
                lastChild = lastChild.next
            }
            if (currNext != null) {
                lastChild!!.next = currNext
                currNext.prev = lastChild
            }
            curr.child = null
            curr = curr.next
        }
        return head
    }
}
