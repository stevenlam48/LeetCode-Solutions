package distributecandiesamongchildreni
// Time:  O(1)
// Space: O(1)

class Solution {
    fun distributeCandies(n: Int, limit: Int): Long {
        fun nCr(n: Int, r: Int): Long {
            if (r !in 0..n) {
                return 0L
            }
            var rr = r
            if (n - rr < rr) {
                rr = n - rr
            }
            var result = 1L
            for (k in 1..rr) {
                result *= (n - k + 1).toLong()
                result /= k
            }
            return result
        }
        fun nHr(n: Int, r: Int): Long = nCr(n + r - 1, r - 1)
        val children = 3
        var result = 0L
        for (r in 0..children) {
            result += (if (r % 2 != 0) -1L else 1L) * nCr(children, r) * nHr(n - r * (limit + 1), children)
        }
        return result
    }
}
