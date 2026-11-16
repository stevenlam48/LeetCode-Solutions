package kthdigitininfinitestring
// Time:  O(logk)
// Space: O(1)

class Solution {
    fun kthDigit(k: Long): Int {
        fun digit(value: Long, count: Int): Int {
            var x = value
            var r = 0
            for (i in 0 until count) {
                r = (x % 10).toInt()
                x /= 10
            }
            return r
        }

        var index = k - 1
        var base = 1L
        var l = 1L
        while (9L * base * l <= index) {
            index -= 9L * base * l
            base *= 10
            ++l
        }
        val q = index / l
        val r = index % l
        val d = base + q
        val result = digit(d, (l - r).toInt())
        return if (r != l - 1 || (d / 10) % 2 == 0L) result else 9 - result
    }
}
