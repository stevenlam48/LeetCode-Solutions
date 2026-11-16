package swapnodesinpairs
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var curr = dummy
        while (curr.next?.next != null) {
            val nextOne = curr.next!!
            val nextTwo = nextOne.next!!
            val nextThree = nextTwo.next
            curr.next = nextTwo
            nextTwo.next = nextOne
            nextOne.next = nextThree
            curr = nextOne
        }
        return dummy.next
    }
}
