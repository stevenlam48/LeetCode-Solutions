package addtwonumbersii

import common.ListNode

// Time:  O(m + n)
// Space: O(m + n)

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stk1 = ArrayDeque<Int>()
        val stk2 = ArrayDeque<Int>()
        var first = l1
        var second = l2
        while (first != null) {
            stk1.addLast(first.`val`)
            first = first.next
        }
        while (second != null) {
            stk2.addLast(second.`val`)
            second = second.next
        }
        var prev: ListNode? = null
        var head: ListNode? = null
        var sum = 0
        while (stk1.isNotEmpty() || stk2.isNotEmpty()) {
            sum /= 10
            if (stk1.isNotEmpty()) {
                sum += stk1.removeLast()
            }
            if (stk2.isNotEmpty()) {
                sum += stk2.removeLast()
            }
            head = ListNode(sum % 10)
            head.next = prev
            prev = head
        }
        if (sum >= 10) {
            head = ListNode(sum / 10)
            head.next = prev
        }
        return head
    }
}
