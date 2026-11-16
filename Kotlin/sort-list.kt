package sortlist

// Time:  O(nlogn)
// Space: O(logn)

import common.ListNode

class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast?.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        fast = slow
        slow = slow?.next
        fast?.next = null

        return mergeTwoLists(sortList(head), sortList(slow))
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var left = l1
        var right = l2
        while (left != null && right != null) {
            if (left.`val` <= right.`val`) {
                curr.next = left
                left = left.next
            } else {
                curr.next = right
                right = right.next
            }
            curr = curr.next!!
        }
        curr.next = left ?: right
        return dummy.next
    }
}
