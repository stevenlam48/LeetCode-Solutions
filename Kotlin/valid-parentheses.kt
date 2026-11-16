package validparentheses

import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isValid(s: String): Boolean {
        val symbolPair = mapOf(
            ')' to '(',
            ']' to '[',
            '}' to '{'
        )
        val parentheses = ArrayDeque<Char>()
        for (c in s) {
            val opening = symbolPair[c]
            if (opening != null) {
                if (parentheses.isEmpty() || parentheses.peekLast() != opening) {
                    return false
                }
                parentheses.removeLast()
            } else {
                parentheses.addLast(c)
            }
        }
        return parentheses.isEmpty()
    }
}
