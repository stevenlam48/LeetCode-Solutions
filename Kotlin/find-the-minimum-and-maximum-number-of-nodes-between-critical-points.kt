package findtheminimumandmaximumnumberofnodesbetweencriticalpoints

import common.ListNode

// Time:  O(n)
// Space: O(1)

class Solution {
    fun nodesBetweenCriticalPoints(head: ListNode?): IntArray {
        var first = -1
        var last = -1
        var result = Int.MAX_VALUE
        var prev = head!!.`val`
        var node = head.next
        var i = 0
        while (node!!.next != null) {
            val nextVal = node.next!!.`val`
            if (!((maxOf(prev, nextVal) < node.`val`) ||
                    (minOf(prev, nextVal) > node.`val`))) {
                prev = node.`val`
                node = node.next
                ++i
                continue
            }
            if (first == -1) {
                first = i
            }
            if (last != -1) {
                result = minOf(result, i - last)
            }
            last = i
            prev = node.`val`
            node = node.next
            ++i
        }
        if (last == first) {
            return intArrayOf(-1, -1)
        }
        return intArrayOf(result, last - first)
    }
}
