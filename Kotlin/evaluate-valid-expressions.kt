package evaluatevalidexpressions

// Time:  O(n)
// Space: O(n)
class Solution {
    fun evaluateExpression(expression: String): Long {
        val lookup = mapOf<String, (Long, Long) -> Long>(
            "add" to { a, b -> a + b },
            "sub" to { a, b -> a - b },
            "mul" to { a, b -> a * b },
            "div" to { a, b -> a / b }
        )

        val symbols = "(,)"

        val curr = StringBuilder()
        val ops = ArrayList<String>()
        val params = ArrayList<MutableList<Long>>()
        params.add(ArrayList())
        for (x in expression) {
            if (!symbols.contains(x)) {
                curr.append(x)
                continue
            }
            if (x == '(') {
                ops.add(curr.toString())
                curr.setLength(0)
                params.add(ArrayList())
                continue
            }
            if (curr.isNotEmpty()) {
                params.last().add(curr.toString().toLong())
                curr.setLength(0)
            }
            if (x != ')') {
                continue
            }
            val op = ops.removeAt(ops.size - 1)
            val param = params.removeAt(params.size - 1)
            params.last().add(lookup[op]!!(param[0], param[1]))
        }
        return if (params[0].isNotEmpty()) params[0][0] else curr.toString().toLong()
    }
}
