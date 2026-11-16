package usingarobottoprintthelexicographicallysmalleststring

// Time:  O(n)
// Space: O(n)

class Solution {
    fun robotWithString(s: String): String {
        val count = IntArray(26)
        for (c in s) {
            ++count[c - 'a']
        }
        val result = StringBuilder()
        val stack = StringBuilder()
        var mn = 'a'
        for (c in s) {
            stack.append(c)
            --count[c - 'a']
            while (mn < 'z' && count[mn - 'a'] == 0) {
                ++mn
            }
            while (stack.isNotEmpty() && stack.last() <= mn) {
                result.append(stack.last())
                stack.deleteCharAt(stack.lastIndex)
            }
        }
        return result.toString()
    }
}
