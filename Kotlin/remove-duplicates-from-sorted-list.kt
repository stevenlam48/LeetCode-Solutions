package removeduplicatesfromsortedlist

import common.ListNode

// Time:  O(n)
// Space: O(1)
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var iter = head
        while (iter != null) {
            var runner = iter.next
            while (runner != null && runner.`val` == iter.`val`) {
                runner = runner.next
            }
            iter.next = runner
            iter = runner
        }
        return head
    }
}
