package checkifwordisvalidaftersubstitutions

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isValid(s: String): Boolean {
        val stack = StringBuilder()
        for (c in s) {
            if (c == 'c') {
                if (stack.length >= 2 &&
                    stack[stack.length - 2] == 'a' &&
                    stack[stack.length - 1] == 'b'
                ) {
                    stack.deleteCharAt(stack.length - 1)
                    stack.deleteCharAt(stack.length - 1)
                } else {
                    return false
                }
            } else {
                stack.append(c)
            }
        }
        return stack.isEmpty()
    }
}
