package removenodesfromlinkedlist

import common.ListNode

// Time:  O(n)
// Space: O(n)
class Solution {
    fun removeNodes(head: ListNode?): ListNode? {
        val stk = ArrayList<ListNode>()
        var curr = head
        while (curr != null) {
            while (stk.isNotEmpty() && stk[stk.size - 1].`val` < curr.`val`) {
                stk.removeAt(stk.size - 1)
            }
            if (stk.isNotEmpty()) {
                stk[stk.size - 1].next = curr
            }
            stk.add(curr)
            curr = curr.next
        }
        return if (stk.isEmpty()) null else stk[0]
    }
}
