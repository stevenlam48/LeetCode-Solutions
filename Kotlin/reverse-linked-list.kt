package reverselinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        val dummy = ListNode(0)

        while (current != null) {
            val tmp = current.next
            current.next = dummy.next
            dummy.next = current
            current = tmp
        }

        return dummy.next
    }
}
