package mergetwosortedlists

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
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
