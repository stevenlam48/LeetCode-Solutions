package removeduplicatesfromanunsortedlinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(n)
class Solution {
    fun deleteDuplicatesUnsorted(head: ListNode?): ListNode? {
        val count = HashMap<Int, Int>()
        var curr = head
        while (curr != null) {
            count[curr.`val`] = (count[curr.`val`] ?: 0) + 1
            curr = curr.next
        }
        val dummy = ListNode(0)
        dummy.next = head
        var prev: ListNode = dummy
        while (prev.next != null) {
            val node = prev.next!!
            if (count[node.`val`] == 1) {
                prev = node
            } else {
                prev.next = node.next
            }
        }
        return dummy.next
    }
}
