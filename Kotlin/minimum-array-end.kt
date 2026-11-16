package minimumarrayend

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun minEnd(n: Int, x: Int): Long {
        var remaining = n - 1
        var result = x.toLong()
        var baseN = 1L
        var baseX = 1L
        while (baseN <= remaining) {
            if (x.toLong() and baseX == 0L) {
                if (remaining.toLong() and baseN != 0L) {
                    result = result or baseX
                }
                baseN = baseN shl 1
            }
            baseX = baseX shl 1
        }
        return result
    }
}
