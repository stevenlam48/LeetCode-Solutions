package convertsortedlisttobinarysearchtree

import common.ListNode
import common.TreeNode

// Time:  O(n)
// Space: O(logn)

class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var curr = head
        var n = 0
        while (curr != null) {
            curr = curr.next
            ++n
        }
        return buildBSTFromSortedListHelper(arrayOf(head), 0, n)
    }

    private fun buildBSTFromSortedListHelper(head: Array<ListNode?>, s: Int, e: Int): TreeNode? {
        if (s == e) {
            return null
        }

        val m = s + (e - s) / 2
        val left = buildBSTFromSortedListHelper(head, s, m)
        val curr = TreeNode(head[0]!!.`val`)

        head[0] = head[0]!!.next
        curr.left = left
        curr.right = buildBSTFromSortedListHelper(head, m + 1, e)
        return curr
    }
}
