package reversenodesinevenlengthgroups
// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        var prev = head ?: return null
        var length = 2
        while (prev.next != null) {
            var curr = prev
            var count = 0
            while (count < length && curr.next != null) {
                ++count
                curr = curr.next!!
            }
            ++length
            if (count % 2 != 0) {
                prev = curr
                continue
            }
            var node = prev.next
            var last: ListNode? = null
            while (count-- > 0) {
                val next = node!!.next
                node.next = last
                last = node
                node = next
            }
            val tail = prev.next!!
            tail.next = node
            prev.next = last
            prev = tail
        }
        return head
    }
}
