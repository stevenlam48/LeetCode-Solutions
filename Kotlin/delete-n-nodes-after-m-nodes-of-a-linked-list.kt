package deletennodesaftermnodesofalinkedlist

// Time:  O(n)
// Space: O(1)
import common.ListNode

class Solution {
    fun deleteNodes(head: ListNode?, m: Int, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var current: ListNode? = dummy
        while (current != null) {
            for (i in 0 until m) {
                if (current?.next == null) return dummy.next
                current = current.next
            }
            val prev = current
            for (i in 0 until n) {
                if (current?.next == null) {
                    prev?.next = null
                    return dummy.next
                }
                current = current.next
            }
            prev?.next = current?.next
        }
        return dummy.next
    }
}
