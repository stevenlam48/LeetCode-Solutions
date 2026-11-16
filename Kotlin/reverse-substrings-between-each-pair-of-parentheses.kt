package reversesubstringsbetweeneachpairofparentheses
// Time:  O(n)
// Space: O(n)

class Solution {
    fun reverseParentheses(s: String): String {
        val stack = mutableListOf<Int>()
        val lookup = HashMap<Int, Int>()
        for (i in s.indices) {
            if (s[i] == '(') {
                stack.add(i)
            } else if (s[i] == ')') {
                val j = stack.removeAt(stack.lastIndex)
                lookup[i] = j
                lookup[j] = i
            }
        }
        val result = StringBuilder()
        var i = 0
        var direction = 1
        while (i in s.indices) {
            val paired = lookup[i]
            if (paired != null) {
                i = paired
                direction *= -1
            } else {
                result.append(s[i])
            }
            i += direction
        }
        return result.toString()
    }
}
