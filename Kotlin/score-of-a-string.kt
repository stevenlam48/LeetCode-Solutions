package scoreofastring

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun scoreOfString(s: String): Int {
        var result = 0
        for (i in 0 until s.length - 1) {
            result += abs(s[i + 1].code - s[i].code)
        }
        return result
    }
}
