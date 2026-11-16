package superpalindromes

import kotlin.math.pow

// Time:  O(n^0.25 * logn)
// Space: O(logn)

class Solution {
    fun superpalindromesInRange(L: String, R: String): Int {
        val K = 10.0.pow((R.length + 1) * 0.25).toInt()
        val l = L.toLong()
        val r = R.toLong()
        var result = 0

        // count odd length
        for (k in 0 until K) {
            val s = k.toString()
            val revS = s.reversed()
            var v = (s + revS.substring(1)).toLong()
            v *= v
            if (v > r) {
                break
            }
            if (v >= l && isPalindrome(v)) {
                ++result
            }
        }

        // count even length
        for (k in 0 until K) {
            val s = k.toString()
            val revS = s.reversed()
            var v = (s + revS).toLong()
            v *= v
            if (v > r) {
                break
            }
            if (v >= l && isPalindrome(v)) {
                ++result
            }
        }

        return result
    }

    private fun isPalindrome(k: Long): Boolean {
        val s = k.toString()
        return s == s.reversed()
    }
}
