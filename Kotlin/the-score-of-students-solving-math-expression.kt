package thescoreofstudentssolvingmathexpression

// Time:  O(n^3 * a^2)
// Space: O(n^2)

class Solution {
    fun scoreOfStudents(s: String, answers: IntArray): Int {
        val maxAns = 1000

        val n = (s.length + 1) / 2
        val dp = Array(n) { Array(n) { HashSet<Int>() } }
        for (i in 0 until n) {
            dp[i][i].add(s[i * 2] - '0')
        }
        for (l in 1 until n) {
            for (left in 0 until n - l) {
                val right = left + l
                for (k in left until right) {
                    for (x in dp[left][k]) {
                        for (y in dp[k + 1][right]) {
                            val z = if (s[2 * k + 1] == '+') x + y else x * y
                            if (z <= maxAns) {
                                dp[left][right].add(z)
                            }
                        }
                    }
                }
            }
        }
        val target = evaluate(s)
        var result = 0
        for (ans in answers) {
            if (ans == target) {
                result += 5
            } else if (dp[0][n - 1].contains(ans)) {
                result += 2
            }
        }
        return result
    }

    private fun evaluate(s: String): Int {
        val precedence = mapOf('+' to 0, '*' to 1)

        val operands = ArrayList<Long>()
        val operators = ArrayList<Char>()
        for (c in s) {
            if (c.isDigit()) {
                operands.add((c - '0').toLong())
            } else {
                while (operators.isNotEmpty() && precedence[operators.last()]!! >= precedence[c]!!) {
                    compute(operands, operators)
                }
                operators.add(c)
            }
        }
        while (operators.isNotEmpty()) {
            compute(operands, operators)
        }
        return operands.last().toInt()
    }

    private fun compute(operands: ArrayList<Long>, operators: ArrayList<Char>) {
        val right = operands.removeAt(operands.size - 1)
        val left = operands.removeAt(operands.size - 1)
        val op = operators.removeAt(operators.size - 1)
        if (op == '+') {
            operands.add(left + right)
        } else if (op == '*') {
            operands.add(left * right)
        }
    }
}
