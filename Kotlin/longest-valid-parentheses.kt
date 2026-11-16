package longestvalidparentheses

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestValidParentheses(s: String): Int {
        return maxOf(
            length(s, 0, s.length, 1, '('),
            length(s, s.length - 1, -1, -1, ')')
        )
    }

    private fun length(s: String, begin: Int, end: Int, step: Int, c: Char): Int {
        var len = 0
        var depth = 0
        var start = begin
        var it = begin
        while (it != end) {
            if (s[it] == c) {
                ++depth
            } else {
                --depth
                if (depth < 0) {
                    start = it + step
                    depth = 0
                } else {
                    if (depth == 0) {
                        len = maxOf(len, Math.abs(it - start) + 1)
                    }
                }
            }
            it += step
        }
        return len
    }
}
