package linkedlistcomponents
// Time:  O(m + n), m is the number of G, n is the number of nodes
// Space: O(m)

import common.ListNode

class Solution {
    fun numComponents(head: ListNode?, G: IntArray): Int {
        val lookup = G.toHashSet()
        val dummy = ListNode(-1)
        dummy.next = head
        var curr: ListNode? = dummy
        var result = 0
        while (curr?.next != null) {
            val next = curr.next!!
            if (curr.`val` !in lookup && next.`val` in lookup) {
                ++result
            }
            curr = next
        }
        return result
    }
}
