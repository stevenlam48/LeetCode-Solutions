package oddevenlinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        val h = head ?: return head
        var oddTail = h
        var curr = h.next
        while (curr != null && curr.next != null) {
            val evenHead = oddTail.next
            oddTail.next = curr.next
            oddTail = oddTail.next!!
            curr.next = oddTail.next
            oddTail.next = evenHead
            curr = curr.next
        }
        return head
    }
}
