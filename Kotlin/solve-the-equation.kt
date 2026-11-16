package solvetheequation

// Time:  O(n)
// Space: O(n)

class Solution {
    fun solveEquation(equation: String): String {
        var a = 0
        var b = 0
        var side = 1
        var i = 0
        while (i < equation.length) {
            if (equation[i] == '=') {
                side = -1
                ++i
                continue
            }
            var sign = 1
            if (equation[i] == '+') {
                ++i
            } else if (equation[i] == '-') {
                sign = -1
                ++i
            }
            var num = 0
            var hasNum = false
            while (i < equation.length && equation[i].isDigit()) {
                num = num * 10 + (equation[i] - '0')
                hasNum = true
                ++i
            }
            if (i < equation.length && equation[i] == 'x') {
                ++i
                a += side * sign * (if (hasNum) num else 1)
            } else if (hasNum) {
                b -= side * sign * num
            }
        }
        return if (a != 0) {
            "x=" + (b / a)
        } else if (b != 0) {
            "No solution"
        } else {
            "Infinite solutions"
        }
    }
}
