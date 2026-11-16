package smallestgreatermultiplemadeoftwodigits

// Time:  sum(O(l * 2^l) for l in range(1, 11)) = O(20 * 2^10) = O(1)
// Space: O(1)

class Solution {
    fun findInteger(k: Int, digit1: Int, digit2: Int): Int {
        val maxNumOfDigits = 10
        var d1 = digit1
        var d2 = digit2
        if (d1 < d2) {
            val tmp = d1
            d1 = d2
            d2 = tmp
        }
        var l = 1
        var total = 2
        while (l <= maxNumOfDigits) {
            for (mask in 0 until total) {
                var curr = 0L
                var bit = total shr 1
                while (bit != 0) {
                    curr = curr * 10 + (if ((mask and bit) != 0) d1 else d2)
                    bit = bit shr 1
                }
                if (k < curr && curr <= Int.MAX_VALUE && curr % k == 0L) {
                    return curr.toInt()
                }
            }
            ++l
            total = total shl 1
        }
        return -1
    }
}
