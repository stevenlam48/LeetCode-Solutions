package removeduplicateletters

// Time:  O(n)
// Space: O(k), k is size of the alphabet
class Solution {
    fun removeDuplicateLetters(s: String): String {
        val k = 26
        val remaining = IntArray(k)
        for (c in s) {
            ++remaining[c - 'a']
        }

        val inStack = BooleanArray(k)
        val stk = StringBuilder()
        for (c in s) {
            if (!inStack[c - 'a']) {
                while (stk.isNotEmpty() && stk[stk.length - 1] > c && remaining[stk[stk.length - 1] - 'a'] > 0) {
                    inStack[stk[stk.length - 1] - 'a'] = false
                    stk.setLength(stk.length - 1)
                }
                stk.append(c)
                inStack[c - 'a'] = true
            }
            --remaining[c - 'a']
        }
        return stk.toString()
    }
}
