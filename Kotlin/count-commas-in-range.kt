package countcommasinrange

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countCommas(n: Int): Int {
        var cnt = 0
        var base = 1
        while (base * 1000 <= n) {
            ++cnt
            base *= 1000
        }
        var result = 0
        base = 1
        for (i in 0 until cnt) {
            base *= 1000
            result += n - base + 1
        }
        return result
    }
}
