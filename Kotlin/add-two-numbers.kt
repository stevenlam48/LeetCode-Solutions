package addtwonumbers

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        val dummy = ListNode(0)
        var curr = dummy
        var carry = 0

        while (first != null || second != null || carry != 0) {
            val a = first?.`val` ?: 0
            val b = second?.`val` ?: 0
            val value = carry + a + b
            curr.next = ListNode(value % 10)
            carry = value / 10
            first = first?.next
            second = second?.next
            curr = curr.next!!
        }

        return dummy.next
    }
}
