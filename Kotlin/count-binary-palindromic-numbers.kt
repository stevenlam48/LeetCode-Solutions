package countbinarypalindromicnumbers

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countBinaryPalindromes(n: Long): Int {
        fun length(value: Long): Int {
            var n = value
            var result = 0
            while (n != 0L) {
                ++result
                n = n shr 1
            }
            return result
        }

        fun reverse(value: Long, l: Int): Long {
            var result = 0L
            for (i in 0 until l) {
                if (value and (1L shl i) != 0L) {
                    result = result or (1L shl (l - 1 - i))
                }
            }
            return result
        }

        val l = length(n) / 2
        val p = ((n shr l) shl l) or reverse(n shr (length(n) - l), l)
        return ((1 shl l) - 1) + (n shr l).toInt() + if (p <= n) 1 else 0
    }
}
