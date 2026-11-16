package removeoutermostparentheses

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeOuterParentheses(S: String): String {
        val deep = 1
        val result = StringBuilder()
        var cnt = 0
        for (c in S) {
            if (c == '(' && cnt++ >= deep) {
                result.append(c)
            }
            if (c == ')' && cnt-- > deep) {
                result.append(c)
            }
        }
        return result.toString()
    }
}
