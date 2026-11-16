package leastoperatorstoexpressnumber
// Time:  O(logn/logx) = O(1)
// Space: O(logn) = O(1)

class Solution {
    fun leastOpsExpressTarget(x: Int, target: Int): Int {
        var pos = 0
        var neg = 0
        var k = 0
        var remaining = target
        while (remaining > 0) {
            val r = remaining % x
            if (k > 0) {
                val newPos = minOf(r * k + pos, (r + 1) * k + neg)
                val newNeg = minOf((x - r) * k + pos, (x - r - 1) * k + neg)
                pos = newPos
                neg = newNeg
            } else {
                pos = r * 2
                neg = (x - r) * 2
            }
            ++k
            remaining /= x
        }
        return minOf(pos, k + neg) - 1
    }
}
