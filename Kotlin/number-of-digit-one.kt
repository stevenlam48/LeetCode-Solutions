package numberofdigitone

// Time:  O(logn) = O(1)
// Space: O(1)

class Solution {
    fun countDigitOne(n: Int): Int {
        val digit = 1
        val isZero = if (digit == 0) 1 else 0
        var result = isZero
        var base = 1L
        while (n >= base) {
            result += ((n / (10 * base) - isZero) * base +
                minOf(base, maxOf(n % (10 * base) - digit * base + 1, 0L))).toInt()
            base *= 10
        }
        return result
    }
}
