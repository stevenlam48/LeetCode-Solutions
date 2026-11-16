package removenthnodefromendoflist

import common.ListNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var slow: ListNode = dummy
        var fast: ListNode = dummy

        // fast is n-step ahead.
        var k = n
        while (k > 0) {
            fast = fast.next!!
            --k
        }

        // When fast reaches the end, slow must be nth to last node.
        while (fast.next != null) {
            slow = slow.next!!
            fast = fast.next!!
        }

        slow.next = slow.next!!.next

        return dummy.next
    }
}
