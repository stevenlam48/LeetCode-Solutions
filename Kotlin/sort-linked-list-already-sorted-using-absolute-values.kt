package sortlinkedlistalreadysortedusingabsolutevalues

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun sortLinkedList(head: ListNode?): ListNode? {
        var currentHead = head!!
        var tail = currentHead
        var curr = currentHead.next
        currentHead.next = null
        while (curr != null) {
            val next = curr.next
            if (curr.`val` > 0) {
                curr.next = null
                tail.next = curr
                tail = curr
            } else {
                curr.next = currentHead
                currentHead = curr
            }
            curr = next
        }
        return currentHead
    }
}
