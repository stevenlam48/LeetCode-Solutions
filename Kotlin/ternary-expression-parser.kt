package ternaryexpressionparser
// Time:  O(n)
// Space: O(1)

class Solution {
    fun parseTernary(expression: String): String {
        if (expression.isEmpty()) {
            return ""
        }
        val stack = ArrayDeque<Char>()
        for (i in expression.length - 1 downTo 0) {
            val c = expression[i]
            if (stack.isNotEmpty() && stack.last() == '?') {
                stack.removeLast()
                val first = stack.removeLast()
                stack.removeLast()
                val second = stack.removeLast()
                if (c == 'T') {
                    stack.addLast(first)
                } else {
                    stack.addLast(second)
                }
            } else {
                stack.addLast(c)
            }
        }
        return stack.last().toString()
    }
}
