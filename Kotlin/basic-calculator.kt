package basiccalculator

// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun calculate(s: String): Int {
        val operands = ArrayDeque<Long>()
        val operators = ArrayDeque<Char>()
        var operand = 0L
        for (i in s.indices) {
            if (s[i].isDigit()) {
                operand = operand * 10 + (s[i] - '0')
                if (i + 1 == s.length || !s[i + 1].isDigit()) {
                    operands.push(operand)
                    operand = 0
                }
            } else if (s[i] == '(') {
                operators.push(s[i])
            } else if (s[i] == ')') {
                while (operators.peek() != '(') {
                    compute(operands, operators)
                }
                operators.pop()
            } else if (s[i] in PRECEDENCE) {
                while (operators.isNotEmpty() && operators.peek() in PRECEDENCE &&
                    PRECEDENCE.getValue(operators.peek()) >= PRECEDENCE.getValue(s[i])) {
                    compute(operands, operators)
                }
                operators.push(s[i])
            }
        }
        while (operators.isNotEmpty()) {
            compute(operands, operators)
        }
        return operands.peek().toInt()
    }

    private fun compute(operands: ArrayDeque<Long>, operators: ArrayDeque<Char>) {
        val right = operands.pop()
        val left = operands.pop()
        when (operators.pop()) {
            '+' -> operands.push(left + right)
            '-' -> operands.push(left - right)
            '*' -> operands.push(left * right)
            '/' -> operands.push(left / right)
        }
    }

    companion object {
        private val PRECEDENCE = mapOf('+' to 0, '-' to 0, '*' to 1, '/' to 1)
    }
}
