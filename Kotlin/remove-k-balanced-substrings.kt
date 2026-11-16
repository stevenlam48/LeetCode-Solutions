package removekbalancedsubstrings

// Time:  O(n)
// Space: O(n)
class Solution {
    fun removeSubstring(s: String, k: Int): String {
        var cnt = 0
        val count = { x: Char ->
            if (x == '(') {
                if (cnt < k) {
                    ++cnt
                } else if (cnt > k) {
                    cnt = 1
                }
            } else {
                if (cnt >= k) {
                    ++cnt
                } else {
                    cnt = 0
                }
            }
        }

        val result = StringBuilder()
        for (x in s) {
            result.append(x)
            count(x)
            if (cnt != 2 * k) {
                continue
            }
            repeat(2 * k) {
                result.setLength(result.length - 1)
            }
            cnt = 0
            for (i in maxOf(result.length - (2 * k - 1), 0) until result.length) {
                count(result[i])
            }
        }
        return result.toString()
    }
}
