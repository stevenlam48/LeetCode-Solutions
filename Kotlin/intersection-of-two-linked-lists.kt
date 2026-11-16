package intersectionoftwolinkedlists
// Time:  O(m + n)
// Space: O(1)

import common.ListNode

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var currentA = headA
        var currentB = headB
        while (currentA !== currentB) {
            currentA = if (currentA != null) currentA.next else headB
            currentB = if (currentB != null) currentB.next else headA
        }
        return currentA
    }
}
