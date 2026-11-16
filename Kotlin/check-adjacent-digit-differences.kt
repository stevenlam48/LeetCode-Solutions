package checkadjacentdigitdifferences

import kotlin.math.abs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isAdjacentDiffAtMostTwo(s: String): Boolean {
        for (i in 0 until s.length - 1) {
            if (abs(s[i].code - s[i + 1].code) > 2) {
                return false
            }
        }
        return true
    }
}
