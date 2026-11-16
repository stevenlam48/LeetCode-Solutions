package expressionaddoperators

// Time:  O(4^n)
// Space: O(n)

class Solution {
    fun addOperators(num: String, target: Int): List<String> {
        val result = mutableListOf<String>()
        val expr = mutableListOf<String>()
        var value = 0
        val valueString = StringBuilder()
        for (i in num.indices) {
            value = value * 10 + (num[i] - '0')
            valueString.append(num[i])
            if (value.toString() != valueString.toString()) {
                break
            }
            expr.add(valueString.toString())
            addOperatorsDFS(num, target, i + 1, 0, value, expr, result)
            expr.removeAt(expr.lastIndex)
        }
        return result
    }

    private fun addOperatorsDFS(
        num: String,
        target: Int,
        pos: Int,
        operand1: Int,
        operand2: Int,
        expr: MutableList<String>,
        result: MutableList<String>
    ) {
        if (pos == num.length && operand1 + operand2 == target) {
            result.add(expr.joinToString(""))
        } else {
            var value = 0
            val valueString = StringBuilder()
            for (i in pos until num.length) {
                value = value * 10 + (num[i] - '0')
                valueString.append(num[i])
                if (value.toString() != valueString.toString()) {
                    break
                }

                expr.add("+$valueString")
                addOperatorsDFS(num, target, i + 1, operand1 + operand2, value, expr, result)
                expr.removeAt(expr.lastIndex)

                expr.add("-$valueString")
                addOperatorsDFS(num, target, i + 1, operand1 + operand2, -value, expr, result)
                expr.removeAt(expr.lastIndex)

                expr.add("*$valueString")
                addOperatorsDFS(num, target, i + 1, operand1, operand2 * value, expr, result)
                expr.removeAt(expr.lastIndex)
            }
        }
    }
}
