package parsingabooleanexpression

// Time:  O(n)
// Space: O(n)

class Solution {
    fun parseBoolExpr(expression: String): Boolean {
        val i = intArrayOf(0)
        return parse(expression, i)
    }

    private fun parse(expression: String, i: IntArray): Boolean {
        val ch = expression[i[0]]
        if (ch != '&' && ch != '|' && ch != '!') {
            val result = ch == 't'
            ++i[0]
            return result
        }
        val op = ch
        i[0] += 2
        val stk = ArrayList<Boolean>()
        while (expression[i[0]] != ')') {
            if (expression[i[0]] == ',') {
                ++i[0]
                continue
            }
            stk.add(parse(expression, i))
        }
        ++i[0]
        if (op == '&') {
            return stk.all { it }
        }
        if (op == '|') {
            return stk.any { it }
        }
        return !stk[0]
    }
}
