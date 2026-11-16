package nthdigit

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun findNthDigit(n: Int): Int {
        var n = n.toLong()
        var digitLen = 1L
        while (n > digitLen * 9 * pow10(digitLen - 1)) {
            n -= digitLen * 9 * pow10(digitLen - 1)
            ++digitLen
        }

        val num = pow10(digitLen - 1) + (n - 1) / digitLen

        var nthDigit = num / pow10((digitLen - 1) - (n - 1) % digitLen)
        nthDigit %= 10

        return nthDigit.toInt()
    }

    private fun pow10(exp: Long): Long {
        var result = 1L
        for (i in 0 until exp) {
            result *= 10
        }
        return result
    }
}
