package linkedlistfrequency

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun frequenciesOfElements(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var node = head
        var cnt = 0
        while (node != null) {
            ++cnt
            if (node.next == null || node.next!!.`val` != node.`val`) {
                curr.next = ListNode(cnt)
                curr = curr.next!!
                cnt = 0
            }
            node = node.next
        }
        return dummy.next
    }
}
