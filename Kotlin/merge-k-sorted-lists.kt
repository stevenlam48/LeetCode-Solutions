package mergeksortedlists
// Time:  O(n * logk), n is the length of the result list.
// Space: O(1)

import common.ListNode

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        var left = 0
        var right = lists.size - 1
        while (right > 0) {
            lists[left] = mergeTwoLists(lists[left], lists[right])
            ++left
            --right
            if (left >= right) {
                left = 0
            }
        }
        return lists[0]
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        val dummy = ListNode(0)
        var curr = dummy
        while (first != null && second != null) {
            if (first.`val` <= second.`val`) {
                curr.next = first
                first = first.next
            } else {
                curr.next = second
                second = second.next
            }
            curr = curr.next!!
        }
        curr.next = first ?: second
        return dummy.next
    }
}
