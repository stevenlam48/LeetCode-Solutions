package basiccalculatoriv

// Time:  +:        O(d * t), t is the number of terms, d is the average degree of terms
//        -:        O(d * t)
//        *:        O(d * t^2)
//        eval:     O(d * t)
//        to_list:  O(d * tlogt)
// Space: O(e + d * t), e is the number of evalvars

import java.util.ArrayDeque

class Poly {
    private val polies = HashMap<List<String>, Int>()

    constructor()

    constructor(expr: String) {
        val key = mutableListOf<String>()
        if (isNumber(expr)) {
            val value = expr.toInt()
            if (value != 0) {
                polies[key] = value
            }
        } else {
            key.add(expr)
            update(key, 1)
        }
    }

    operator fun plus(rhs: Poly): Poly {
        val result = Poly()
        for ((key, value) in polies) {
            result.update(key, value)
        }
        for ((key, value) in rhs.polies) {
            result.update(key, value)
        }
        return result
    }

    operator fun minus(rhs: Poly): Poly {
        val result = Poly()
        for ((key, value) in polies) {
            result.update(key, value)
        }
        for ((key, value) in rhs.polies) {
            result.update(key, -value)
        }
        return result
    }

    operator fun times(rhs: Poly): Poly {
        val result = Poly()
        for ((key1, value1) in polies) {
            for ((key2, value2) in rhs.polies) {
                result.update(merge(key1, key2), value1 * value2)
            }
        }
        return result
    }

    fun eval(lookup: Map<String, Int>): Poly {
        val result = Poly()
        for ((tokens, value) in polies) {
            val key = mutableListOf<String>()
            var coefficient = value
            for (token in tokens) {
                if (token in lookup) {
                    coefficient *= lookup.getValue(token)
                } else {
                    key.add(token)
                }
            }
            result.update(key, coefficient)
        }
        return result
    }

    fun toList(): List<String> {
        val sorted = polies.entries.sortedWith { left, right ->
            if (left.key.size != right.key.size) {
                right.key.size.compareTo(left.key.size)
            } else {
                compareKeys(left.key, right.key)
            }
        }
        return sorted.map { (key, value) ->
            (listOf(value.toString()) + key).joinToString("*")
        }
    }

    private fun isNumber(s: String): Boolean = s.isNotEmpty() && s.all { it.isDigit() }

    private fun update(key: List<String>, value: Int) {
        val updated = (polies[key] ?: 0) + value
        if (updated == 0) {
            polies.remove(key)
        } else {
            polies[key] = updated
        }
    }

    private fun merge(arr1: List<String>, arr2: List<String>): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        var j = 0
        while (i < arr1.size || j < arr2.size) {
            if (j == arr2.size || (i != arr1.size && arr1[i] < arr2[j])) {
                result.add(arr1[i++])
            } else {
                result.add(arr2[j++])
            }
        }
        return result
    }

    private fun compareKeys(left: List<String>, right: List<String>): Int {
        for (i in 0 until minOf(left.size, right.size)) {
            val comparison = left[i].compareTo(right[i])
            if (comparison != 0) {
                return comparison
            }
        }
        return left.size.compareTo(right.size)
    }
}

class Solution {
    fun basicCalculatorIV(expression: String, evalvars: List<String>, evalints: IntArray): List<String> {
        val lookup = HashMap<String, Int>()
        for (i in evalvars.indices) {
            lookup[evalvars[i]] = evalints[i]
        }
        return parse(expression).eval(lookup).toList()
    }

    private fun parse(s: String): Poly {
        val operands = ArrayDeque<Poly>()
        val operators = ArrayDeque<Char>()
        val operand = StringBuilder()
        for (i in s.indices) {
            if (s[i].isLetterOrDigit()) {
                operand.append(s[i])
                if (i + 1 == s.length || !s[i + 1].isLetterOrDigit()) {
                    operands.push(Poly(operand.toString()))
                    operand.setLength(0)
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
        return operands.peek()
    }

    private fun compute(operands: ArrayDeque<Poly>, operators: ArrayDeque<Char>) {
        val right = operands.pop()
        val left = operands.pop()
        when (operators.pop()) {
            '+' -> operands.push(left + right)
            '-' -> operands.push(left - right)
            '*' -> operands.push(left * right)
        }
    }

    companion object {
        private val PRECEDENCE = mapOf('+' to 0, '-' to 0, '*' to 1)
    }
}
