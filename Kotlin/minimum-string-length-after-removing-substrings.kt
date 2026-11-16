package minimumstringlengthafterremovingsubstrings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minLength(s: String): Int {
        val stk = StringBuilder()
        for (c in s) {
            if (stk.isNotEmpty() && ((stk.last() == 'A' && c == 'B') || (stk.last() == 'C' && c == 'D'))) {
                stk.deleteCharAt(stk.lastIndex)
                continue
            }
            stk.append(c)
        }
        return stk.length
    }
}
