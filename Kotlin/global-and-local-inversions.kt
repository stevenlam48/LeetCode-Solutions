package globalandlocalinversions

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun isIdealPermutation(a: IntArray): Boolean {
        for (i in a.indices) {
            if (abs(a[i] - i) > 1) {
                return false
            }
        }
        return true
    }
}
