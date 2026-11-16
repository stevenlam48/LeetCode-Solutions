package sumofcompatiblenumbersinrangei

// Time:  O(log(n + k))
// Space: O(1)

// bitmasks, combinatorics
class Solution {
    fun sumOfGoodIntegers(n: Int, k: Int): Int {
        fun count(x: Int): Int {
            if (x <= 0) {
                return 0
            }
            val l = 32 - Integer.numberOfLeadingZeros(x)
            var total = 0
            var cnt = 1
            for (i in 0 until l) {
                if (n and (1 shl i) != 0) {
                    continue
                }
                total = total * 2 + (1 shl i) * cnt
                cnt *= 2
            }
            var result = 0
            var prefix = 0
            for (i in l - 1 downTo 0) {
                if (n and (1 shl i) == 0) {
                    cnt /= 2
                    total = (total - (1 shl i) * cnt) / 2
                }
                if (x and (1 shl i) == 0) {
                    continue
                }
                result += prefix * cnt + total
                if (n and (1 shl i) != 0) {
                    return result
                }
                prefix = prefix or (1 shl i)
            }
            result += prefix
            return result
        }

        return count(n + k) - count((n - k) - 1)
    }
}
