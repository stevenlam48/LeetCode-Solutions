package fractionadditionandsubtraction

// Time:  O(nlogx), x is the max denominator
// Space: O(n)

import kotlin.math.abs

class Solution {
    fun fractionAddition(expression: String): String {
        var numerator = 0
        var denominator = 1
        var index = 0
        while (index < expression.length) {
            var end = index + 1
            while (end < expression.length && expression[end].isDigit()) {
                ++end
            }
            val a = expression.substring(index, end).toInt()
            index = end + 1
            end = index + 1
            while (end < expression.length && expression[end].isDigit()) {
                ++end
            }
            val b = expression.substring(index, end).toInt()
            numerator = numerator * b + a * denominator
            denominator *= b
            val g = abs(gcd(numerator, denominator))
            numerator /= g
            denominator /= g
            index = end
        }
        return "$numerator/$denominator"
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }
}
