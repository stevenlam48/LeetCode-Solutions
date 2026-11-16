package rotatelist

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        var tail: ListNode = head
        var n = 1
        while (tail.next != null) {
            tail = tail.next!!
            ++n
        }
        tail.next = head

        var newTail: ListNode? = tail
        val shift = n - k % n
        var curr: ListNode? = head
        var i = 0
        while (i < shift) {
            newTail = curr
            curr = curr!!.next
            ++i
        }

        newTail!!.next = null
        return curr
    }
}
