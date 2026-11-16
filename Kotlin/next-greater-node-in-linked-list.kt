package nextgreaternodeinlinkedlist
// Time:  O(n)
// Space: O(n)

import common.ListNode

class Solution {
    fun nextLargerNodes(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        val stk = mutableListOf<Pair<Int, Int>>()
        var node = head
        while (node != null) {
            while (stk.isNotEmpty() && stk.last().second < node.`val`) {
                result[stk.removeAt(stk.lastIndex).first] = node.`val`
            }
            stk.add(result.size to node.`val`)
            result.add(0)
            node = node.next
        }
        return result.toIntArray()
    }
}
