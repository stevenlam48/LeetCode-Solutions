package evaluatereversepolishnotation

// Time:  O(n)
// Space: O(n)
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        if (tokens.isEmpty()) {
            return 0
        }
        val s = ArrayDeque<String>()
        for (tok in tokens) {
            if (!isOperator(tok)) {
                s.addLast(tok)
            } else {
                var y = s.removeLast().toInt()
                var x = s.removeLast().toInt()
                if (tok[0] == '+') {
                    x += y
                } else if (tok[0] == '-') {
                    x -= y
                } else if (tok[0] == '*') {
                    x *= y
                } else {
                    x /= y
                }
                s.addLast(x.toString())
            }
        }
        return s.removeLast().toInt()
    }

    private fun isOperator(op: String): Boolean {
        return op.length == 1 && "+-*/".contains(op)
    }
}
