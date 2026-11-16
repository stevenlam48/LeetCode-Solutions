package swappingnodesinalinkedlist
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var left: ListNode? = null
        var right: ListNode? = null
        var remainingK = k
        var curr = head
        while (curr != null) {
            if (right != null) {
                right = right.next
            }
            if (--remainingK == 0) {
                left = curr
                right = head
            }
            curr = curr.next
        }
        val value = left!!.`val`
        left.`val` = right!!.`val`
        right.`val` = value
        return head
    }
}
