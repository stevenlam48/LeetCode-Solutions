package partitionlist

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val dummySmaller = ListNode(0)
        val dummyLarger = ListNode(0)
        var smaller = dummySmaller
        var larger = dummyLarger
        var current = head
        while (current != null) {
            val next = current.next
            if (current.`val` < x) {
                smaller.next = current
                smaller = current
            } else {
                larger.next = current
                larger = current
            }
            current = next
        }
        smaller.next = dummyLarger.next
        larger.next = null
        return dummySmaller.next
    }
}
