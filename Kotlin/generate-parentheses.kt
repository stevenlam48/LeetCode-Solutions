package generateparentheses

import java.util.ArrayDeque

// Time:  O(4^n / n^(3/2)) ~= Catalan numbers
// Space: O(n)

// iterative solution
class Solution {
    fun generateParentheses(n: Int): List<String> {
        val result = mutableListOf<String>()
        val curr = StringBuilder()
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, n, n, 0))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val step = top[0]
            val left = top[1]
            val right = top[2]
            val c = top[3]
            if (step == 1) {
                if (left == 0 && right == 0) {
                    result.add(curr.toString())
                }
                if (left < right) {
                    stk.addLast(intArrayOf(3, 0, 0, 0))
                    stk.addLast(intArrayOf(1, left, right - 1, 0))
                    stk.addLast(intArrayOf(2, 0, 0, ')'.code))
                }
                if (left > 0) {
                    stk.addLast(intArrayOf(3, 0, 0, 0))
                    stk.addLast(intArrayOf(1, left - 1, right, 0))
                    stk.addLast(intArrayOf(2, 0, 0, '('.code))
                }
            } else if (step == 2) {
                curr.append(c.toChar())
            } else if (step == 3) {
                curr.setLength(curr.length - 1)
            }
        }
        return result
    }
}
