package convertbinarynumberinalinkedlisttointeger

import common.ListNode
// Time:  O(n)
// Space: O(1)

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var result = 0
        var current = head
        while (current != null) {
            result = result * 2 + current.`val`
            current = current.next
        }
        return result
    }
}
