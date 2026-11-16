package reverselinkedlistii

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head

        var prev: ListNode? = dummy

        for (i in 0 until m - 1) {
            prev = prev!!.next
        }

        val head2 = prev!!

        prev = prev.next
        var cur = prev!!.next

        for (i in m until n) {
            prev!!.next = cur!!.next
            cur.next = head2.next
            head2.next = cur
            cur = prev.next
        }

        return dummy.next
    }
}
