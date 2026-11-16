package winnerofthelinkedlistgame

// Time:  O(n)
// Space: O(1)

import common.ListNode

class Solution {
    fun gameResult(head: ListNode?): String {
        var cnt = 0
        var current = head
        while (current != null) {
            val next = current.next!!
            cnt += if (current.`val` == next.`val`) 0 else if (current.`val` < next.`val`) -1 else 1
            current = next.next
        }
        return if (cnt == 0) "Tie" else if (cnt < 0) "Odd" else "Even"
    }
}
