package findthepivotinteger
// Time:  O(1)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun pivotInteger(n: Int): Int {
        val x = (sqrt(((n + 1) * n / 2).toDouble()) + 0.5).toInt()
        return if (x * x == (n + 1) * n / 2) x else -1
    }
}
