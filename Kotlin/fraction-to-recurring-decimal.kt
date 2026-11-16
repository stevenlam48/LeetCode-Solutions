package fractiontorecurringdecimal

// Time:  O(logn), where logn is the length of result strings
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val result = StringBuilder()
        if ((numerator xor denominator) shr 31 != 0 && numerator != 0) {
            result.append('-')
        }

        var dvd = abs(numerator.toLong())
        val dvs = abs(denominator.toLong())
        result.append(dvd / dvs)
        dvd %= dvs
        if (dvd > 0) {
            result.append('.')
        }

        val lookup = HashMap<Long, Int>()
        while (dvd != 0L && !lookup.containsKey(dvd)) {
            lookup[dvd] = result.length
            dvd *= 10
            result.append(dvd / dvs)
            dvd %= dvs
        }

        if (lookup.containsKey(dvd)) {
            result.insert(lookup.getValue(dvd), '(')
            result.append(')')
        }
        return result.toString()
    }
}
