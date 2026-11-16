package doubleanumberrepresentedasalinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(1)

// linked list
class Solution {
    fun doubleIt(head: ListNode?): ListNode? {
        var h = head ?: return null
        if (h.`val` >= 5) {
            val node = ListNode(0)
            node.next = h
            h = node
        }
        var curr: ListNode? = h
        while (curr != null) {
            curr.`val` = (curr.`val` * 2) % 10
            if (curr.next != null && curr.next!!.`val` >= 5) {
                ++curr.`val`
            }
            curr = curr.next
        }
        return h
    }
}
