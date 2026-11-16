package insertgreatestcommondivisorsinlinkedlist
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current = head
        while (current?.next != null) {
            val next = current.next!!
            val inserted = ListNode(gcd(current.`val`, next.`val`))
            inserted.next = next
            current.next = inserted
            current = inserted.next
        }
        return head
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }
}
