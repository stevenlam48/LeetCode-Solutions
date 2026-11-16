package scoreofparentheses

// Time:  O(n)
// Space: O(1)

class Solution {
    fun scoreOfParentheses(S: String): Int {
        var result = 0
        var depth = 0
        for (i in S.indices) {
            if (S[i] == '(') {
                ++depth
            } else {
                --depth
                if (S[i - 1] == '(') {
                    result += 1 shl depth
                }
            }
        }
        return result
    }
}
