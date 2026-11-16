package smallestsubsequenceofdistinctcharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun smallestSubsequence(text: String): String {
        val count = IntArray(26)
        for (c in text) {
            ++count[c - 'a']
        }
        val lookup = BooleanArray(26)
        val stk = StringBuilder()
        for (c in text) {
            if (!lookup[c - 'a']) {
                while (stk.isNotEmpty() && stk.last() > c && count[stk.last() - 'a'] != 0) {
                    lookup[stk.last() - 'a'] = false
                    stk.deleteCharAt(stk.lastIndex)
                }
                stk.append(c)
                lookup[c - 'a'] = true
            }
            --count[c - 'a']
        }
        return stk.toString()
    }
}
