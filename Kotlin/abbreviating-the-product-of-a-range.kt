package abbreviatingtheproductofarange

import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

// Time:  O(r - l)
// Space: O(1)

class Solution {
    fun abbreviateProduct(left: Int, right: Int): String {
        val prefixLen = 5
        val suffixLen = 5
        val mod = 10.0.pow(prefixLen + suffixLen).toLong()

        var curr = 1L
        var zeros = 0L
        var abbr = false
        var decimal = 0.0
        var i = left.toLong()
        while (i <= right) {
            curr *= i
            decimal += log10(i.toDouble())
            while (curr % 10 == 0L) {
                curr /= 10
                ++zeros
            }
            if (curr >= mod) {
                abbr = true
            }
            curr %= mod
            ++i
        }
        if (!abbr) {
            return curr.toString() + "e" + zeros
        }
        decimal -= floor(decimal)
        val prefix = 10.0.pow(decimal + (prefixLen - 1)).toInt().toString()
        val suffix = (curr % 10.0.pow(suffixLen).toInt()).toString()
        return prefix + "..." + "0".repeat(suffixLen - suffix.length) + suffix + "e" + zeros
    }
}
