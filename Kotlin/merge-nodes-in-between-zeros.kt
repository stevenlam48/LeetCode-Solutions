package mergenodesinbetweenzeros
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun mergeNodes(head: ListNode): ListNode {
        var curr = head.next
        var zero = head
        while (curr != null) {
            if (curr.`val` != 0) {
                zero.`val` += curr.`val`
            } else {
                zero.next = if (curr.next != null) curr else null
                zero = curr
            }
            curr = curr.next
        }
        return head
    }
}
