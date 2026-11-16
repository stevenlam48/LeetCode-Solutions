package mergeinbetweenlinkedlists
// Time:  O(m + n)
// Space: O(1)

import common.ListNode

class Solution {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var prevFirst: ListNode? = null
        var last = list1
        for (i in 0 until b) {
            if (i == a - 1) {
                prevFirst = last
            }
            last = last!!.next
        }
        prevFirst!!.next = list2
        var tail = list2
        while (tail!!.next != null) {
            tail = tail.next
        }
        tail.next = last!!.next
        last.next = null
        return list1
    }
}
