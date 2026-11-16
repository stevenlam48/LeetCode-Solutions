package plusonelinkedlist
import common.ListNode
// Time:  O(n)
// Space: O(1)

class Solution {
    fun plusOne(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val dummy = ListNode(0)
        dummy.next = head
        var left: ListNode = dummy
        var right: ListNode = head
        while (right.next != null) {
            if (right.`val` != 9) {
                left = right
            }
            right = right.next!!
        }
        if (right.`val` != 9) {
            ++right.`val`
        } else {
            ++left.`val`
            var curr = left.next
            while (curr != null) {
                curr.`val` = 0
                curr = curr.next
            }
        }
        return if (dummy.`val` == 0) dummy.next else dummy
    }
}
