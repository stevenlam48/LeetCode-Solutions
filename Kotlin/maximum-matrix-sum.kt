package maximummatrixsum

// Time:  O(n^2)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var absTotal = 0L
        var minAbsValue = Long.MAX_VALUE
        var isNegativeCountOdd = false
        for (row in matrix) {
            for (value in row) {
                val absValue = abs(value.toLong())
                absTotal += absValue
                minAbsValue = minOf(minAbsValue, absValue)
                if (value < 0) {
                    isNegativeCountOdd = !isNegativeCountOdd
                }
            }
        }
        return if (!isNegativeCountOdd) absTotal else absTotal - 2 * minAbsValue
    }
}
