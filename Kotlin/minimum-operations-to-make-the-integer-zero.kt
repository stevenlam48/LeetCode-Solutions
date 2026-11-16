package minimumoperationstomaketheintegerzero

// Time:  O(1)
// Space: O(1)

// math, linear search, bit manipulations
class Solution {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        for (i in 1L..60L) {
            val v = num1 - i * num2
            if (v < 0) {
                break
            }
            if (java.lang.Long.bitCount(v) <= i && i <= v) {
                return i.toInt()
            }
        }
        return -1
    }
}
