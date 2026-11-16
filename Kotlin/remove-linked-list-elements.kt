package removelinkedlistelements

import common.ListNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var prev: ListNode = dummy
        var cur = dummy.next

        while (cur != null) {
            if (cur.`val` == `val`) {
                prev.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }
        return dummy.next
    }
}
