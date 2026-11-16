package spiralmatrixiv

// Time:  O(m * n)
// Space: O(1)

import common.ListNode

class Solution {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val result = Array(m) { IntArray(n) { -1 } }
        var i = 0
        var j = 0
        var d = 0
        var node = head
        while (node != null) {
            result[i][j] = node.`val`
            val ni = i + directions[d][0]
            val nj = j + directions[d][1]
            if (!(0 <= ni && ni < m && 0 <= nj && nj < n && result[ni][nj] == -1)) {
                d = (d + 1) % 4
            }
            i += directions[d][0]
            j += directions[d][1]
            node = node.next
        }
        return result
    }
}
