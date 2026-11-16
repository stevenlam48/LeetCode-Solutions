package removezerosumconsecutivenodesfromlinkedlist
// Time:  O(n)
// Space: O(n)

import common.ListNode
import java.util.ArrayDeque

class Solution {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var curr: ListNode? = dummy
        var prefix = 0
        val lookup = HashMap<Int, ListNode>()
        val order = ArrayDeque<Int>()
        while (curr != null) {
            prefix += curr.`val`
            var node = curr
            if (lookup.containsKey(prefix)) {
                node = lookup[prefix]!!
            }
            while (lookup.containsKey(prefix)) {
                lookup.remove(order.removeFirst())
            }
            order.addFirst(prefix)
            lookup[prefix] = node
            node.next = curr.next
            curr = curr.next
        }
        return dummy.next
    }
}
