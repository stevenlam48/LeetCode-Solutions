package splitlinkedlistinparts

// Time:  O(n + k)
// Space: O(1)

import common.ListNode

class Solution {
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        var n = 0
        var curr = root
        while (curr != null) {
            curr = curr.next
            ++n
        }
        val width = n / k
        val remainder = n % k

        val result = arrayOfNulls<ListNode>(k)
        curr = root
        for (i in 0 until k) {
            val head = curr
            var j = 0
            while (curr != null && j < width - 1 + if (i < remainder) 1 else 0) {
                curr = curr.next
                ++j
            }
            if (curr != null) {
                val tail = curr
                curr = curr.next
                tail.next = null
            }
            result[i] = head
        }
        return result
    }
}
