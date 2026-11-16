package reversenodesinkgroup
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var curr = head
        var currDummy = dummy
        var length = 0
        while (curr != null) {
            val nextCurr = curr.next
            length = (length + 1) % k
            if (length == 0) {
                val nextDummy = currDummy.next
                reverse(currDummy, curr.next)
                currDummy = nextDummy!!
            }
            curr = nextCurr
        }
        return dummy.next
    }

    private fun reverse(begin: ListNode, end: ListNode?) {
        val first = begin.next
        var curr = first!!.next
        while (curr != end) {
            first.next = curr!!.next
            curr.next = begin.next
            begin.next = curr
            curr = first.next
        }
    }
}
