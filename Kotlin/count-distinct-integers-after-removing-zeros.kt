package countdistinctintegersafterremovingzeros

// Time:  O(logn)
// Space: O(1)

// combinatorics
class Solution {
    fun countDistinct(n: Long): Long {
        var m: Long
        var base: Long
        var x = n + 1
        var reversed = 0L
        var b = 1L
        while (x != 0L) {
            reversed = reversed * 10 + x % 10
            x /= 10
            b *= 9
        }
        m = reversed
        base = b

        var result = (base - 9) / 8
        base /= 9
        while (base != 0L) {
            val r = (m % 10).toInt()
            if (r == 0) {
                break
            }
            result += (r - 1) * base
            base /= 9
            m /= 10
        }
        return result
    }
}
