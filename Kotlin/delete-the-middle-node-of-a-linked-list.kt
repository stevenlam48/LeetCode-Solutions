package deletethemiddlenodeofalinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var slow: ListNode? = dummy
        var fast: ListNode? = dummy
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        slow!!.next = slow.next?.next
        return dummy.next
    }
}
