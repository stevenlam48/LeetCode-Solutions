package dividetwointegers

// Time:  O(logn) = O(1)
// Space: O(1)

// Only using integer type.
class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        // Handle corner case.
        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var a = if (dividend > 0) -dividend else dividend
        val b = if (divisor > 0) -divisor else divisor

        var shift = 0
        while (b shl shift < 0 && shift < 32) {
            ++shift
        }
        shift -= 1

        var result = 0
        while (shift >= 0) {
            if (a <= b shl shift) {
                a -= b shl shift
                result += 1 shl shift
            }
            --shift
        }

        result = if ((dividend xor divisor) shr 31 != 0) -result else result
        return result
    }
}
