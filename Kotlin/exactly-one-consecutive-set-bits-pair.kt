package exactlyoneconsecutivesetbitspair

// Time:  O(1)
// Space: O(1)
class Solution {
    fun consecutiveSetBits(n: Int): Boolean {
        fun isPowerOf2(n: Int): Boolean {
            return n > 0 && (n and (n - 1)) == 0
        }

        return isPowerOf2(n and (n shr 1))
    }
}
