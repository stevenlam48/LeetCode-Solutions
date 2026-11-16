package splitacircularlinkedlist

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun splitCircularLinkedList(list: ListNode?): List<ListNode?> {
        val head1 = list!!
        var slow = head1
        var fast = head1.next!!
        while (fast.next != head1) {
            slow = slow.next!!
            fast = if (fast.next!!.next != head1) fast.next!!.next!! else fast.next!!
        }
        val head2 = slow.next
        slow.next = head1
        fast.next = head2
        return listOf(head1, head2)
    }
}
