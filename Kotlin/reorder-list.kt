package reorderlist
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun reorderList(head: ListNode?) {
        if (head == null) {
            return
        }
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        val tmp = slow!!.next
        slow.next = null
        slow = tmp
        merge(head, reverse(slow))
    }

    private fun reverse(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = head
        while (curr != null) {
            val tmp = curr.next
            curr.next = dummy.next
            dummy.next = curr
            curr = tmp
        }
        return dummy.next
    }

    private fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var ptr = dummy
        var first = list1
        var second = list2
        while (first != null && second != null) {
            val tmp = first.next
            ptr.next = first
            ptr = first
            ptr.next = second
            ptr = second
            first = tmp
            second = second.next
        }
        if (first != null) {
            ptr.next = first
        }
        return dummy.next
    }
}
