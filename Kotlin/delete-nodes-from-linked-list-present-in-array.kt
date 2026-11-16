package deletenodesfromlinkedlistpresentinarray

// Time:  O(n)
// Space: O(m)
import common.ListNode

class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val lookup = nums.toHashSet()
        val dummy = ListNode(0)
        dummy.next = head
        var curr = dummy
        while (curr.next != null) {
            if (!lookup.contains(curr.next!!.`val`)) {
                curr = curr.next!!
            } else {
                curr.next = curr.next!!.next
            }
        }
        return dummy.next
    }
}
