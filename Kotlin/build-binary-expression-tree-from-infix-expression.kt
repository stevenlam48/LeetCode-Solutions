package buildbinaryexpressiontreefrominfixexpression

// Time:  O(n)
// Space: O(n)

class Node(var `val`: Char, var left: Node? = null, var right: Node? = null)

class Solution {
    fun expTree(s: String): Node {
        val precedence = mapOf('+' to 0, '-' to 0, '*' to 1, '/' to 1)
        val operands = ArrayDeque<Node>()
        val operators = ArrayDeque<Char>()
        var operand = 0L
        for (i in s.indices) {
            if (s[i].isDigit()) {
                operand = operand * 10 + (s[i] - '0')
                if (i + 1 == s.length || !s[i + 1].isDigit()) {
                    operands.addLast(Node((operand + '0'.code).toInt().toChar()))
                    operand = 0
                }
            } else if (s[i] == '(') {
                operators.addLast(s[i])
            } else if (s[i] == ')') {
                while (operators.isNotEmpty() && operators.last() != '(') {
                    compute(operands, operators)
                }
                operators.removeLast()
            } else if (s[i] in precedence) {
                while (operators.isNotEmpty() && operators.last() in precedence &&
                    precedence.getValue(operators.last()) >= precedence.getValue(s[i])
                ) {
                    compute(operands, operators)
                }
                operators.addLast(s[i])
            }
        }
        while (operators.isNotEmpty()) {
            compute(operands, operators)
        }
        return operands.last()
    }

    private fun compute(operands: ArrayDeque<Node>, operators: ArrayDeque<Char>) {
        val right = operands.removeLast()
        val left = operands.removeLast()
        val op = operators.removeLast()
        operands.addLast(Node(op, left, right))
    }
}
