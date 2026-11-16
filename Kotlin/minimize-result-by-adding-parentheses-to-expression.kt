package minimizeresultbyaddingparenthesestoexpression

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun minimizeResult(expression: String): String {
        fun parse(start: Int, end: Int): Int {
            if (start == end) {
                return 1
            }
            var result = 0
            for (i in start until end) {
                result = result * 10 + (expression[i] - '0')
            }
            return result
        }

        fun pow10(exponent: Int): Int {
            var result = 1
            repeat(exponent) {
                result *= 10
            }
            return result
        }

        val pos = expression.indexOf('+')
        val left = parse(0, pos)
        val right = parse(pos + 1, expression.length)
        var minValue = Int.MAX_VALUE
        var bestI = 0
        var bestJ = pos + 1
        val base2Init = pow10(expression.length - (pos + 1) - 1)
        var base1 = pow10(pos)
        for (i in 0 until pos) {
            var base2 = base2Init
            for (j in pos + 1 until expression.length) {
                val a = left / base1
                val b = left % base1
                val c = right / base2
                val d = right % base2
                val value = maxOf(a, 1) * (b + c) * maxOf(d, 1)
                if (value < minValue) {
                    minValue = value
                    bestI = i
                    bestJ = j
                }
                base2 /= 10
            }
            base1 /= 10
        }
        val result = StringBuilder()
        for (i in expression.indices) {
            if (i == bestI) {
                result.append('(')
            }
            result.append(expression[i])
            if (i == bestJ) {
                result.append(')')
            }
        }
        return result.toString()
    }
}
