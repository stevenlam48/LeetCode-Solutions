package minimizeroundingerrortomeettarget

// Time:  O(n) on average
// Space: O(n)

import java.util.Locale
import kotlin.math.ceil
import kotlin.math.floor

class Solution {
    fun minimizeError(prices: List<String>, target: Int): String {
        val errors = ArrayList<Double>()
        var lower = 0
        var upper = 0
        for (price in prices) {
            val p = price.toDouble()
            val floorValue = floor(p)
            lower += floorValue.toInt()
            upper += ceil(p).toInt()
            if (p != floorValue) {
                errors.add(p - floorValue)
            }
        }
        if (target < lower || target > upper) {
            return "-1"
        }

        val lowerRoundCount = upper - target
        val errorValues = errors.toDoubleArray()
        nthElement(errorValues, lowerRoundCount)
        var minError = 0.0
        for (i in errorValues.indices) {
            minError += if (i < lowerRoundCount) {
                errorValues[i]
            } else {
                1.0 - errorValues[i]
            }
        }
        val result = String.format(Locale.US, "%.6f", minError)
        return result.substring(0, result.indexOf('.') + 4)
    }

    private fun nthElement(values: DoubleArray, position: Int) {
        if (position <= 0 || position >= values.size) {
            return
        }
        var left = 0
        var right = values.lastIndex
        while (left < right) {
            val pivot = values[(left + right) ushr 1]
            var i = left
            var j = right
            while (i <= j) {
                while (values[i] < pivot) {
                    ++i
                }
                while (values[j] > pivot) {
                    --j
                }
                if (i <= j) {
                    val temp = values[i]
                    values[i] = values[j]
                    values[j] = temp
                    ++i
                    --j
                }
            }
            if (position <= j) {
                right = j
            } else if (position >= i) {
                left = i
            } else {
                return
            }
        }
    }
}
