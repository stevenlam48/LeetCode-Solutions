package deletenodeinalinkedlist

// Time:  O(1)
// Space: O(1)
import common.ListNode

class Solution {
    fun deleteNode(node: ListNode?) {
        if (node?.next == null) return
        node.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}
