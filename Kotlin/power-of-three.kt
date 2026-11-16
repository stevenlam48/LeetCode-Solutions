package powerofthree
import kotlin.math.ln
import kotlin.math.pow
// Time:  O(1)
// Space: O(1)

class Solution {
    companion object {
        private val MAX_LOG3 = (ln(Int.MAX_VALUE.toDouble()) / ln(3.0)).toInt()
        private val MAX_POW3 = 3.0.pow(MAX_LOG3).toInt()
    }

    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && MAX_POW3 % n == 0
    }
}
