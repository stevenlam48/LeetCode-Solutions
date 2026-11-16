package countcommasinrangeii

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countCommas(n: Long): Long {
        var cnt = 0
        var base = 1L
        while (base * 1000 <= n) {
            ++cnt
            base *= 1000
        }
        var result = 0L
        base = 1L
        for (i in 0 until cnt) {
            base *= 1000
            result += n - base + 1
        }
        return result
    }
}
