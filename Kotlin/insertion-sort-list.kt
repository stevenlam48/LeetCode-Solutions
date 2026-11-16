package insertionsortlist
// Time:  O(n^2)
// Space: O(1)

import common.ListNode

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummy = ListNode(Int.MIN_VALUE)
        var current = head
        while (current != null) {
            val position = findInsertPosition(dummy, current.`val`)
            val next = current.next
            current.next = position.next
            position.next = current
            current = next
        }
        return dummy.next
    }

    private fun findInsertPosition(head: ListNode, x: Int): ListNode {
        var previous: ListNode? = null
        var current: ListNode? = head
        while (current != null && current.`val` <= x) {
            previous = current
            current = current.next
        }
        return previous!!
    }
}
