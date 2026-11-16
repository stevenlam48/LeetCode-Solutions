package minimumcosttochangethefinalvalueofexpression
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minOperationsToFlip(expression: String): Int {
        val precedence = mapOf('&' to 0, '|' to 0)
        val operands = ArrayDeque<IntArray>()
        val operators = ArrayDeque<Char>()
        for (c in expression) {
            if (c.isDigit()) {
                operands.addLast(intArrayOf(if (c != '0') 1 else 0, if (c != '1') 1 else 0))
            } else if (c == '(') {
                operators.addLast(c)
            } else if (c == ')') {
                while (operators.last() != '(') {
                    compute(operands, operators)
                }
                operators.removeLast()
            } else if (c in precedence) {
                while (operators.isNotEmpty() && operators.last() in precedence &&
                    precedence[operators.last()]!! >= precedence[c]!!
                ) {
                    compute(operands, operators)
                }
                operators.addLast(c)
            }
        }
        while (operators.isNotEmpty()) {
            compute(operands, operators)
        }
        return operands.last().max()
    }

    private fun compute(operands: ArrayDeque<IntArray>, operators: ArrayDeque<Char>) {
        val right = operands.removeLast()
        val left = operands.removeLast()
        val op = operators.removeLast()
        if (op == '&') {
            operands.addLast(intArrayOf(minOf(left[0], right[0]), minOf(left[1] + right[1], minOf(left[1], right[1]) + 1)))
        } else if (op == '|') {
            operands.addLast(intArrayOf(minOf(left[0] + right[0], minOf(left[0], right[0]) + 1), minOf(left[1], right[1])))
        }
    }
}
