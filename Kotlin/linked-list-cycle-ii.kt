package linkedlistcycleii

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow === fast) {
                slow = head
                while (slow !== fast) {
                    slow = slow?.next
                    fast = fast?.next
                }
                return slow
            }
        }
        return null
    }
}
