package removeduplicatesfromsortedlistii

import common.ListNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var prev: ListNode = dummy
        var curr = head
        while (curr != null) {
            if (curr.next != null && curr.next!!.`val` == curr.`val`) {
                val value = curr.`val`
                while (curr != null && curr.`val` == value) {
                    curr = curr.next
                }
                prev.next = curr
            } else {
                prev.next = curr
                prev = curr
                curr = curr.next
            }
        }
        return dummy.next
    }
}
