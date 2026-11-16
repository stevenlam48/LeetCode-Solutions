package maximumtwinsumofalinkedlist

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun pairSum(head: ListNode?): Int {
        val dummy = ListNode(0)
        dummy.next = head
        var slow = dummy.next
        var fast = dummy.next
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        var result = 0
        var first = head
        var second = reverseList(slow)
        while (first != null) {
            result = maxOf(result, first.`val` + second!!.`val`)
            first = first.next
            second = second.next
        }
        return result
    }

    private fun reverseList(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = head
        while (current != null) {
            val next = current.next
            current.next = dummy.next
            dummy.next = current
            current = next
        }
        return dummy.next
    }
}
