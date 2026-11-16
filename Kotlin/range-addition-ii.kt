package rangeadditionii

// Time:  O(p), p is the number of ops
// Space: O(1)

class Solution {
    fun maxCount(m0: Int, n0: Int, ops: Array<IntArray>): Int {
        var m = m0
        var n = n0
        for (op in ops) {
            m = minOf(m, op[0])
            n = minOf(n, op[1])
        }
        return m * n
    }
}
